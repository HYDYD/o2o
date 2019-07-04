package com.xsyu.o2o.service.impl;

import com.xsyu.o2o.dao.ShopDao;
import com.xsyu.o2o.dto.ShopExecution;
import com.xsyu.o2o.entity.Shop;
import com.xsyu.o2o.enums.ShopStateEnum;
import com.xsyu.o2o.exceptions.ShopOperationException;
import com.xsyu.o2o.service.ShopService;
import com.xsyu.o2o.util.ImageUtil;
import com.xsyu.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by HYDYD.
 * 2019/6/28 21:14
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);

            if (effectedNum <= 0) throw new ShopOperationException("店铺创建失败");

            if (shopImgInputStream != null) {
                try {
                    addShopImg(shop, shopImgInputStream, fileName);
                } catch (Exception e) {
                    throw new ShopOperationException("addShopImg error:" + e.getMessage());
                }
                effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) throw new ShopOperationException("更新图片地址失败");
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    /**
     * 将图片加入shop
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     */
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        String dest = PathUtil.getShopImgPath(shop.getShopId());
        String shopImgAddr = ImageUtil.generatorThumbnail(shopImgInputStream, fileName, dest);
        shop.setShopImg(shopImgAddr);
    }

    /**
     * 直接返回Shop
     *
     * @param shopId
     * @return
     */
    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    /**
     * 更新店铺
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    @Override
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        //是否需要处理图片
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            try {
                if (shopImgInputStream != null && fileName != null && !"".equals(fileName)) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    addShopImg(shop, shopImgInputStream, fileName);
                }
                //更新图片信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) return new ShopExecution(ShopStateEnum.INNER_ERROR);
                shop = shopDao.queryByShopId(shop.getShopId());
                return new ShopExecution(ShopStateEnum.SUCCESS, shop);
            } catch (Exception e) {
                throw new ShopOperationException("modifyShop error:" + e.getMessage());
            }
        }
    }
}

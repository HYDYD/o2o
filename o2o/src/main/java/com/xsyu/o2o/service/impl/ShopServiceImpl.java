package com.xsyu.o2o.service.impl;

import com.xsyu.o2o.dao.ShopDao;
import com.xsyu.o2o.dto.ImageHolder;
import com.xsyu.o2o.dto.ShopExecution;
import com.xsyu.o2o.entity.Shop;
import com.xsyu.o2o.enums.ShopStateEnum;
import com.xsyu.o2o.exceptions.ShopOperationException;
import com.xsyu.o2o.service.ShopService;
import com.xsyu.o2o.util.ImageUtil;
import com.xsyu.o2o.util.PageCalculator;
import com.xsyu.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
    public ShopExecution addShop(Shop shop, ImageHolder thumbnail) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);

            if (effectedNum <= 0) throw new ShopOperationException("店铺创建失败");

            if (thumbnail.getImage() != null) {
                try {
                    addShopImg(shop, thumbnail);
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
     * @param shop
     * @param thumbnail
     */
    private void addShopImg(Shop shop, ImageHolder thumbnail) {
        String dest = PathUtil.getShopImgPath(shop.getShopId());
        String shopImgAddr = ImageUtil.generatorThumbnail(thumbnail, dest);
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
     * @param shop
     * @param thumbnail
     * @return
     */
    @Override
    public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) {
        //是否需要处理图片
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            try {
                if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    addShopImg(shop, thumbnail);
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

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
        int count = shopDao.queryShopCount(shopCondition);
        ShopExecution se = new ShopExecution();
        if (shopList != null) {
            se.setShopList(shopList);
            se.setCount(count);
        } else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }
}

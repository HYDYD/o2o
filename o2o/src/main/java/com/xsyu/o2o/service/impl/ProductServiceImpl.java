package com.xsyu.o2o.service.impl;

import com.xsyu.o2o.dao.ProductDao;
import com.xsyu.o2o.dao.ProductImgDao;
import com.xsyu.o2o.dto.ImageHolder;
import com.xsyu.o2o.dto.ProductExecution;
import com.xsyu.o2o.entity.Product;
import com.xsyu.o2o.entity.ProductImg;
import com.xsyu.o2o.enums.ProductStateEnum;
import com.xsyu.o2o.exceptions.ProductOperationException;
import com.xsyu.o2o.service.ProductService;
import com.xsyu.o2o.util.ImageUtil;
import com.xsyu.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/26 19:18
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Override
    @Transactional
    /**
     * 1.处理缩略图，获取缩略图路径并赋给product
     * 2.往tb_product写入商品信息，获取productId
     * 3.结合productId批量处理商品详情图
     * 4.将详情图列表插入tb_product_img中
     */
    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException {
        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            product.setEnableStatus(1);
            if (thumbnail != null) {
                addThumbnail(product, thumbnail);
            }

            try {
                int effectedNum = productDao.insertProduct(product);
                if (effectedNum <= 0) throw new ProductOperationException("创建商品失败");
            } catch (Exception e) {
                throw new ProductOperationException("创建商品失败：" + e.toString());
            }

            if (productImgList != null && productImgList.size() > 0) {
                addProductImgList(product, productImgList);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        } else {
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 添加缩略图
     * @param product
     * @param thumbnail
     */
    private void addThumbnail(Product product, ImageHolder thumbnail){
        String dest = PathUtil.getShopImgPath(product.getShop().getShopId());
        String thumbnailAddr = ImageUtil.generatorThumbnail(thumbnail, dest);
    }

    /**
     * 添加商品详情图
     * @param product
     * @param productImgHolderList
     */
    private void addProductImgList(Product product, List<ImageHolder> productImgHolderList){
        String dest = PathUtil.getShopImgPath(product.getShop().getShopId());
        List<ProductImg> productImgList = new ArrayList<>();
        for (ImageHolder img :
                productImgHolderList) {
            String imgAddr = ImageUtil.generateNormalImg(img, dest);
            ProductImg productImg = new ProductImg();
            productImg.setImgAddr(imgAddr);
            productImg.setProductId(product.getProductId());
            productImg.setCreateTime(new Date());
            productImgList.add(productImg);
        }
        if (productImgList.size() > 0){
            try {
                int effectNum = productImgDao.batchInsertProductImg(productImgList);
                if (effectNum <= 0) {
                    throw new ProductOperationException("创建商品详情图片失败");
                }
            }catch (Exception e){
                throw new ProductOperationException("创建商品详情图片失败："+e.toString());
            }
        }
    }
}

package com.xsyu.o2o.service;

import com.xsyu.o2o.dto.ShopExecution;
import com.xsyu.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

/**
 * Created by HYDYD.
 * 2019/6/28 21:13
 */
public interface ShopService {
    /**
     * 新加商店
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);

    /**
     * 通过Id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 修改店铺信息 包括处理图片
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName);

    /**
     * 根据shopCondition分页返回相应列表数据
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
}

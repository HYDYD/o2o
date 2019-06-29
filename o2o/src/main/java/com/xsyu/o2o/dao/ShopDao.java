package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.Shop;

/**
 * Created by HYDYD.
 * 2019/6/27 20:27
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}

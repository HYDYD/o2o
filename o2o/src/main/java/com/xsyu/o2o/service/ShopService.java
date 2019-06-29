package com.xsyu.o2o.service;

import com.xsyu.o2o.dto.ShopExecution;
import com.xsyu.o2o.entity.Shop;

import java.io.File;

/**
 * Created by HYDYD.
 * 2019/6/28 21:13
 */
public interface ShopService {
    /**
     * 新加商店
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, File shopImg);
}

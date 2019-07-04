package com.xsyu.o2o.service;

import com.xsyu.o2o.entity.ShopCategory;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/1 18:06
 */
public interface ShopCategoryService {
    /**
     * 获取区域列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategotyList(ShopCategory shopCategoryCondition);
}

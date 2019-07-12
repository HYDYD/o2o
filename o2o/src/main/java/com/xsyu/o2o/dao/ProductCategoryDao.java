package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.ProductCategory;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/12 19:48
 */
public interface ProductCategoryDao {
    /**
     * 返回商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
}

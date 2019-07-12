package com.xsyu.o2o.service;

import com.xsyu.o2o.entity.ProductCategory;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/12 20:01
 */
public interface ProductCategoryService {
    List<ProductCategory> getProductCategoryList(long shopId);
}

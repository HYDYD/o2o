package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.Product;

/**
 * Created by HYDYD.
 * 2019/7/24 21:40
 */
public interface ProductDao {
    /**
     * 插入商品
     * @param product
     * @return
     */
    int insertProduct(Product product);
}

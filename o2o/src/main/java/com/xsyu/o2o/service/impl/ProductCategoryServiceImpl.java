package com.xsyu.o2o.service.impl;

import com.xsyu.o2o.dao.ProductCategoryDao;
import com.xsyu.o2o.entity.ProductCategory;
import com.xsyu.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/12 20:02
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}

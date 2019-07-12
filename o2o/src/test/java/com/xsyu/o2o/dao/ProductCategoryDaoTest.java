package com.xsyu.o2o.dao;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/12 19:55
 */
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryByShopId(){
        long shopId = 1;
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategories.size());
    }
}

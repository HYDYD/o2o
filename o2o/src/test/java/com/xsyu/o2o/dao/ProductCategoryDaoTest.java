package com.xsyu.o2o.dao;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
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

    @Test
    public void testBatchInsertProductCategory(){
        ProductCategory p1 = new ProductCategory();
        p1.setProductCategoryName("商品类别1");
        p1.setPriority(10);
        p1.setCreateTime(new Date());
        p1.setShopId(1L);

        ProductCategory p2 = new ProductCategory();
        p2.setProductCategoryName("商品类别2");
        p2.setPriority(10);
        p2.setCreateTime(new Date());
        p2.setShopId(1L);

        List<ProductCategory> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(list);
        Assert.assertEquals(2,effectedNum);
    }
    
    @Test
    public void testDeleteProductCategory(){
        long shopId = 1;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory pc :
                productCategoryList) {
            if ("商品类别1".equals(pc.getProductCategoryName()) || "商品类别2".equals(pc.getProductCategoryName())){
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(),shopId);
                Assert.assertEquals(1,effectedNum);
            }
        }
    }
}

package com.xsyu.o2o.dao;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/30 16:02
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategoryTest(){
        ShopCategory shopCategory = new ShopCategory();
        ShopCategory shopCategory1 = new ShopCategory();
        shopCategory1.setShopCategoryId(2L);
        shopCategory.setParent(shopCategory1);
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
        Assert.assertEquals(2,shopCategoryList.size());
    }
}

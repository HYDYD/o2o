package com.xsyu.o2o.dao;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.Area;
import com.xsyu.o2o.entity.PersonInfo;
import com.xsyu.o2o.entity.Shop;
import com.xsyu.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/27 20:53
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("大佬王的肥宅奶茶店");
        shop.setShopDesc("老板贼胖，奶茶贼香！");
        shop.setShopAddr("小吃街往里走100m！");
        shop.setPhone("123456789");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中!");

        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);

        shop.setPriority(2);
        shop.setLastEditTime(new Date());

        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1, effectedNum);
    }

    @Test
    public void testQueryShop() {
        long shopId = 6;
        System.out.println(shopDao.queryByShopId(shopId).getArea().getAreaName());
    }

    @Test
    public void testQueryShopList() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 2);
        System.out.println(shopList.size());
    }

    @Test
    public void testQueryShopCount(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        System.out.println(shopDao.queryShopCount(shopCondition));
    }
}

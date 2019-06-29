package com.xsyu.o2o.service;

import com.xsyu.BaseTest;
import com.xsyu.o2o.dto.ShopExecution;
import com.xsyu.o2o.entity.Area;
import com.xsyu.o2o.entity.PersonInfo;
import com.xsyu.o2o.entity.Shop;
import com.xsyu.o2o.entity.ShopCategory;
import com.xsyu.o2o.enums.ShopStateEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

/**
 * Created by HYDYD.
 * 2019/6/29 15:23
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void addShopTest(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("大佬王的奶茶石油分店");
        shop.setShopDesc("老板贼胖，奶茶贼香！");
        shop.setShopAddr("小吃街往里走100m！");
        shop.setPhone("123456789");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中!");

        File shopImg = new File("D:/TheDataOfJava/源码/upload/upload/images/item/headtitle/2017061320315746624.jpg");
        ShopExecution shopExecution = shopService.addShop(shop, shopImg);

        Assert.assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());
    }
}

package com.xsyu.o2o.service;

import com.xsyu.BaseTest;
import com.xsyu.o2o.dto.ImageHolder;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/29 15:23
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void addShopTest() throws FileNotFoundException {
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
        shop.setShopName("大佬王的奶茶石油又双叒叕分店");
        shop.setShopDesc("老板贼胖，奶茶贼香！");
        shop.setShopAddr("小吃街往里走100m！");
        shop.setPhone("123456789");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中!");

        File shopImg = new File("D:/TheDataOfJava/源码/upload/upload/images/item/headtitle/2017061320315746624.jpg");
        InputStream inputStream = new FileInputStream(shopImg);

        ImageHolder imageHolder = new ImageHolder(shopImg.getName(), inputStream);
        ShopExecution shopExecution = shopService.addShop(shop,imageHolder);

        Assert.assertEquals(ShopStateEnum.CHECK.getState(),shopExecution.getState());
    }

    @Test
    public void testModifyShop() throws FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        File shopImg = new File("C:/Users/Verge/Downloads/gakki.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder("gakki.jpg",is);
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
        System.out.println(shopExecution.getShop().getShopImg());
    }

    @Test
    public void testGetShopListAndCount(){
        Shop shopCondition = new Shop();
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        shopCondition.setShopCategory(shopCategory);
        ShopExecution shopExecution = shopService.getShopList(shopCondition, 3, 2);
        System.out.println(shopExecution.getShopList().size());
        System.out.println(shopExecution.getCount());
    }
}

package com.xsyu.o2o.dto;

import com.xsyu.o2o.entity.Shop;
import com.xsyu.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/28 21:02
 */
public class ShopExecution {
    //结果状态
    private int state;

    private String stateInfo;

    //店铺数量
    private int count;

    private Shop shop;

    private List<Shop> shopList;

    public ShopExecution(){}

    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public ShopExecution(ShopStateEnum stateEnum, Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public int getCount() {
        return count;
    }

    public Shop getShop() {
        return shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }
}

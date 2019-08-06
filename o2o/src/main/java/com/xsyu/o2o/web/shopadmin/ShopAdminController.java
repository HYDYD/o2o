package com.xsyu.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HYDYD.
 * 2019/6/30 15:17
 */
@Controller
@RequestMapping(value = "/shopadmin", method = RequestMethod.GET)
public class ShopAdminController {
    @RequestMapping("/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping("/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping("/shopmanagement")
    public String shopManagement(){
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement",method = RequestMethod.GET)
    private String productCategoryManage(){
        return "shop/productcategorymanagement";
    }

    @RequestMapping("/productoperation")
    public String productOperation(){
        return "shop/productoperation";
    }

    @RequestMapping("/productmanagement")
    public String productManagement() { return "shop/productmanagement"; }
}

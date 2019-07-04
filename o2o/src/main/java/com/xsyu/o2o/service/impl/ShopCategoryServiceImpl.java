package com.xsyu.o2o.service.impl;

import com.xsyu.o2o.dao.ShopCategoryDao;
import com.xsyu.o2o.entity.ShopCategory;
import com.xsyu.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/1 18:07
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategotyList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}

package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/30 15:53
 */
public interface ShopCategoryDao {
    /**
     * 返回商铺类别
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition);
}

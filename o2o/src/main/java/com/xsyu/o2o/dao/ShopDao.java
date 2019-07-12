package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/27 20:27
 */
public interface  ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 分页查询店铺，输入条件为店铺名，店铺类别，区域id，owner
     * @param shopConditon
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的行数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopConditon,
                             @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);

    /**
     * 返回queryShopList总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
}

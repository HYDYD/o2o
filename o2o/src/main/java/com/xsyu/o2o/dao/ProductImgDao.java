package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.ProductImg;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/24 21:41
 */
public interface ProductImgDao {

    /**
     * 列出某个商品的详情图列表
     *
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(long productId);

    /**
     * 批量添加商品详情图片
     *
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 删除指定商品下的所有详情图
     *
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(long productId);
}

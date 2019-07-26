package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.ProductImg;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/24 21:41
 */
public interface ProductImgDao {
    /**
     * 批量添加商品详情图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);
}

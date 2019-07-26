package com.xsyu.o2o.service;

import com.xsyu.o2o.dto.ImageHolder;
import com.xsyu.o2o.dto.ProductExecution;
import com.xsyu.o2o.entity.Product;
import com.xsyu.o2o.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/26 17:36
 */
public interface ProductService {
    /**
     * 添加商品及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;
}

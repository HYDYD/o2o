package com.xsyu.o2o.service;

import com.xsyu.o2o.dto.ProductCategoryExecution;
import com.xsyu.o2o.entity.ProductCategory;
import com.xsyu.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/7/12 20:01
 */
public interface ProductCategoryService {
    List<ProductCategory> getProductCategoryList(long shopId);

    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /**
     * 将此类别下的类别id置为空，再删掉商品类别（防止该类别下挂载商品）
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;

}

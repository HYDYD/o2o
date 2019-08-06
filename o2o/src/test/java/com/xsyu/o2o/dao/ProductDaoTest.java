package com.xsyu.o2o.dao;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.Product;
import com.xsyu.o2o.entity.ProductCategory;
import com.xsyu.o2o.entity.ProductImg;
import com.xsyu.o2o.entity.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by HYDYD.
 * 2019/7/25 9:52
 */
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testInsertProduct(){
        Shop shop1 = new Shop();
        shop1.setShopId(1L);
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryId(1L);
        Product product1 = new Product();
        product1.setProductName("测试1");
        product1.setProductDesc("测试Desc1");
        product1.setImgAddr("test1");
        product1.setPriority(1);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop1);
        product1.setProductCategory(pc1);
        Product product2 = new Product();
        product2.setProductName("测试2");
        product2.setProductDesc("测试Desc2");
        product2.setImgAddr("test2");
        product2.setPriority(2);
        product2.setEnableStatus(0);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop1);
        product2.setProductCategory(pc1);
        Product product3 = new Product();
        product3.setProductName("test3");
        product3.setProductDesc("测试Desc3");
        product3.setImgAddr("test3");
        product3.setPriority(3);
        product3.setEnableStatus(1);
        product3.setCreateTime(new Date());
        product3.setLastEditTime(new Date());
        product3.setShop(shop1);
        product3.setProductCategory(pc1);
        // 判断添加是否成功
        int effectedNum = productDao.insertProduct(product1);
        assertEquals(1, effectedNum);
        effectedNum = productDao.insertProduct(product2);
        assertEquals(1, effectedNum);
        effectedNum = productDao.insertProduct(product3);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testQueryProductByProductId(){
        long productId = 1;
        ProductImg p1 = new ProductImg();
        p1.setImgAddr("图片1");
        p1.setImgDesc("测试图片1");
        p1.setPriority(1);
        p1.setCreateTime(new Date());
        p1.setProductId(productId);
        ProductImg p2 = new ProductImg();
        p2.setImgAddr("图片2");
        p2.setImgDesc("测试图片2");
        p2.setPriority(1);
        p2.setCreateTime(new Date());
        p2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<>();
        productImgList.add(p1);
        productImgList.add(p2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2,effectedNum);
        Product product = productDao.queryProductById(productId);
        assertEquals(4,product.getProductImgList().size());
        effectedNum = productImgDao.deleteProductImgByProductId(productId);
        assertEquals(4,effectedNum);
    }

    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        ProductCategory productCategory = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        productCategory.setPriority(2);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductName("第一个产品");
        product.setProductCategory(productCategory);
        int effectedNum = productDao.updateProduct(product);
        assertEquals(1,effectedNum);
    }

    @Test
    public void testQueryProductList() throws Exception {
        Product productCondition = new Product();
        List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
        assertEquals(3, productList.size());
        int count = productDao.queryProductCount(productCondition);
        assertEquals(7, count);
        productCondition.setProductName("测试");
        productList = productDao.queryProductList(productCondition, 0, 4);
        assertEquals(3, productList.size());
        count = productDao.queryProductCount(productCondition);
        assertEquals(3, count);
    }

    @Test
    public void testUpdateProductCategoryToNull() {
        int effectedNum = productDao.updateProductCategoryToNull(1L);
        Assert.assertEquals(4,effectedNum);
    }
}

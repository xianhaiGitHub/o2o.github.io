package com.zxh.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxh.o2o.BaseTest;
import com.zxh.o2o.entity.ProductCategory;

/**
 * 
 * @FixMethodOrder(控制方法按照方法名的顺序执行)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryMappertTest extends BaseTest{
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	
	@Test
	public void testABatchInsertProductCategory(){
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别5");
		productCategory.setPriority(4);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(1L);
		
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别6");
		productCategory2.setPriority(4);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(1L);
		
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryMapper.batchInsertProductCategory(productCategoryList);
		assertEquals(2, effectedNum);
	}
	
	@Test
	public void testBQueryProductCategoryList() throws Exception {
		long shopId = 1;
		List<ProductCategory> productCategoryList = productCategoryMapper.queryProductCategoryList(shopId);
		System.out.println("该店铺自定义类别数为"+ productCategoryList.size());
	}
	

	@Test
	public void testCDeleteProductCategory(){
		long shopId = 1;
		List<ProductCategory> productCategoryList = productCategoryMapper.queryProductCategoryList(shopId);
		for (ProductCategory pc : productCategoryList) {
			if("店铺商品类别5".equals(pc.getProductCategoryName()) || "店铺商品类别6".equals(pc.getProductCategoryName()) ){
				int effectedNum = productCategoryMapper.deleteProductCategory(pc.getProductCategoryId(), shopId);
				assertEquals(1, effectedNum);
			}
		}
	}
}

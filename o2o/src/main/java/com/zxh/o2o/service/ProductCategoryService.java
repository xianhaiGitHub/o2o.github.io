package com.zxh.o2o.service;

import java.util.List;

import com.zxh.o2o.dto.ProductCategoryExecution;
import com.zxh.o2o.entity.ProductCategory;
import com.zxh.o2o.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	
	/**
	 * 	批量添加商品信息
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
	
	
	
	/**
	 * 查看指定店铺下的所有店铺类别信息
	 * @param long shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	
	/**
	 * 将此类别下的商品的类别Id置为空,再删除该商品的类别
	 * 
	 * @param productCategoryId
	 * @param shopId
	 * @return 
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId) throws ProductCategoryOperationException;
}

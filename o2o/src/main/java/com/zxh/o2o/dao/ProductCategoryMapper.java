package com.zxh.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxh.o2o.entity.ProductCategory;

public interface ProductCategoryMapper {
	
	/**
	 * 删除指定商品类别
	 * @param productCategory
	 * @param shopId
	 * @return effectedNum
	 */
	int deleteProductCategory(@Param("productCategoryId") long productCategory, @Param("shopId") long shopId);
	
	/**
	 * 批量添加商品类别 
	 * @param ProductCategoryList
	 * @return
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	/**
	 * 通过shopId 查询店铺商品类别
	 * @param shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);
}
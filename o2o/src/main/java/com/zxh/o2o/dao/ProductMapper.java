package com.zxh.o2o.dao;

import com.zxh.o2o.entity.Product;

public interface ProductMapper {
	
	
	/**
	 * 插入商品
	 * @param product
	 * @return
	 */
	 int insertProduct(Product product);
	 
	
/*    int deleteByPrimaryKey(Integer productId);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);*/
}
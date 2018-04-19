package com.zxh.o2o.dao;

import java.util.List;

import com.zxh.o2o.entity.ProductImg;

public interface ProductImgMapper {
	/**
	 * 批量插入商品图片 
	 * @param productimgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productimgList);
	
	/**
	 * 通过商品Id查询商品图片
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImg(long productId);
	
	/**
	 * 通过商品Id删除商品图片
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
	
  
}
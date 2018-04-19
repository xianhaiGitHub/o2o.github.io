package com.zxh.o2o.service;

import java.util.List;

import com.zxh.o2o.dto.ImageHolder;
import com.zxh.o2o.dto.ProductExecution;
import com.zxh.o2o.entity.Product;
import com.zxh.o2o.exceptions.ProductOperationException;

public interface ProductService {
	
	/**
	 * 添加商品信息以及图片处理
	 * @param product
	 * @param thumbnail
	 * @param productImgList
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution  addProduct(Product product,ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;
}

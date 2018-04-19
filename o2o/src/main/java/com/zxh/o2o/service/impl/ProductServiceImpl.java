package com.zxh.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.o2o.dao.ProductMapper;
import com.zxh.o2o.dto.ImageHolder;
import com.zxh.o2o.dto.ProductExecution;
import com.zxh.o2o.entity.Product;
import com.zxh.o2o.enums.ProductStateEnum;
import com.zxh.o2o.exceptions.ProductOperationException;
import com.zxh.o2o.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Override
	public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException {
		//空置判断
		if(product != null && product.getShop() != null && product.getShop().getShopId() != null){
			//给商品设置默认属性
			product.setCreateTime(new Date());
			product.setLastEditTime(new Date());
			//默认为上架的状态
			product.setEnableStatus(1);
			//r若商品缩略图非空则添加
			if(thumbnail != null) {
				addThumbnail(product,thumbnail);
			}
			try{
				//创建商品信息
				int effectednum = productMapper.insertProduct(product);
				if(effectednum <= 0 ){
					throw new ProductOperationException("创建店铺失败");
				}
			}catch(Exception e){
				throw new ProductOperationException("创建店铺失败" + e.toString());
			}
			//若商品详情阿土非空则添加
			if(productImgList != null && productImgList.size() > 0){
				addProductImageList(product,productImgList);
			}
			return new ProductExecution(ProductStateEnum.SUCCESS,product);
		}else{
			//传参为空则返回空值错误信息
			return new ProductExecution(ProductStateEnum.EMPTY);
			 
		}
	}

	private void addProductImageList(Product product, List<ImageHolder> productImgList) {
		// TODO Auto-generated method stub
		
	}

	private void addThumbnail(Product product, ImageHolder thumbnail) {
		// TODO Auto-generated method stub
		
	}

}

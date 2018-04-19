package com.zxh.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.o2o.dao.ShopMapper;
import com.zxh.o2o.dto.ImageHolder;
import com.zxh.o2o.dto.ShopExecution;
import com.zxh.o2o.entity.Shop;
import com.zxh.o2o.enums.ShopStateEnum;
import com.zxh.o2o.exceptions.ShopOperationException;
import com.zxh.o2o.service.ShopService;
import com.zxh.o2o.util.ImageUtil;
import com.zxh.o2o.util.PageCalculator;
import com.zxh.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper shopMapper;
	
	@Transactional
	@Override
	public ShopExecution addShop(Shop shop,ImageHolder thumbnail) {
		// 判断店铺是否为空
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			// 添加店铺信息
			int effectNum = shopMapper.insertShop(shop);
			if (effectNum <= 0) {
				throw new ShopOperationException("创建店铺失败");
			} else {
				if (thumbnail.getImageName() != null) {
					// 存储图片
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImage error:" + e.getMessage());
					}
					// 更新店铺图片地址
					effectNum = shopMapper.updateShop(shop);
					if (effectNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop errror:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		// 获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImageAddr = ImageUtil.generateThumbnails(thumbnail, dest);
		shop.setShopImg(shopImageAddr);
	}

	@Override
	public Shop getByShopId(long shopId) {
		return shopMapper.queryByShopId(shopId);
	}

	@Override
	public ShopExecution modifyShop(Shop shop,ImageHolder thumbnail)
			throws ShopOperationException {
		// 店铺非空判断
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			// 判断是否需要处理图片
			try{
			if (thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
				Shop tempShop = shopMapper.queryByShopId(shop.getShopId());
				if (tempShop.getShopImg() != null) {
					ImageUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addShopImg(shop, thumbnail);
			}
			// 更新店铺信息
			shop.setLastEditTime(new Date());
			int effectedNum = shopMapper.updateShop(shop);
			if(effectedNum <= 0){
				return new ShopExecution(ShopStateEnum.INNER_ERROR);
			}else {
				shop = shopMapper.queryByShopId(shop.getShopId());
				return new ShopExecution(ShopStateEnum.SUCCESS , shop);
			}}catch(Exception e){
				throw new ShopOperationException("modifyShop error:" + e.getMessage());
			}
		}
	}

	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculatetorRowIndex(pageIndex, pageSize);
		List<Shop> shopList = shopMapper.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopMapper.queryShopCount(shopCondition); 
		ShopExecution se = new ShopExecution();
		if(shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		}else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}

}

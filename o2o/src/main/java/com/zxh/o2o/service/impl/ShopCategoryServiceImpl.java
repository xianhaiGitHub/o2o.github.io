package com.zxh.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.o2o.dao.ShopCategoryMapper;
import com.zxh.o2o.entity.ShopCategory;
import com.zxh.o2o.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		return shopCategoryMapper.queryShopCategory(shopCategoryCondition);
	}

}

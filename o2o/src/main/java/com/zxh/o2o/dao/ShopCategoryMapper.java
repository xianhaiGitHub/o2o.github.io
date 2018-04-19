package com.zxh.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxh.o2o.entity.ProductCategory;
import com.zxh.o2o.entity.ShopCategory;

public interface ShopCategoryMapper {
	
    /**
     * 获取店铺类别 
     * @param shopCategoryCondition
     * @return List<ShopCategory>
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
package com.zxh.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zxh.o2o.entity.Shop;

public interface ShopMapper {

	
	/**
	 *  分页查询店铺，可通过店铺名称(模糊)店铺状态，店铺类别，区域Id owner
	 * @param shopCondition
	 * @param rowIndex 从哪一行开始
	 * @param pageSize 返回多少条数据
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,@Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	/**
	 * 返回queryShopList总数 
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);
	/**
	 * 通过shopid查询店铺
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);
	
   /**
    * 添加店铺
    * @param shop
    * @return
    */
	
	int insertShop(Shop shop);

	/**
	 * 更新店铺
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
	
}
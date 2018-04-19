package com.zxh.o2o.dao;

import static org.junit.Assert.assertEquals;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxh.o2o.BaseTest;
import com.zxh.o2o.entity.Area;
import com.zxh.o2o.entity.PersonInfo;
import com.zxh.o2o.entity.Shop;
import com.zxh.o2o.entity.ShopCategory;

/**
 *
 * @author zhaoxianhai
 * 2018年4月2日
 * @version 1.0
 */
public class ShopMapperTest  extends BaseTest{
	@Autowired
	private ShopMapper shopMapper;
	
	
	
	
	
	@Test
	public void testQueryShopListAndCount(){
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopMapper.queryShopList(shopCondition, 0, 6);
		int count = shopMapper.queryShopCount(shopCondition);
		System.out.println("店铺列表大小" + shopList.size());
		System.out.println("店铺总数：" + count);
	}
	@Test
	@Ignore
	public void testQueryByShopId(){
		long shopId = 1;
		Shop shop = shopMapper.queryByShopId(shopId);
		System.out.println(shop.getArea().getAreaId());
		System.out.println(shop.getArea().getAreaName());
	}
	/**
	 *测试添加店铺
	 */
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopName("testName");
		shop.setShopCategory(shopCategory);
		shop.setShopDesc("testdesc");
		shop.setShopAddr("testaddr");
		shop.setShopImg("testImg");
		shop.setPhone("testphone");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectNum = shopMapper.insertShop(shop);
		assertEquals(1, effectNum);
	}
	/**
	 * 测试更新店铺
	 */
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("testdesc_1");
		shop.setShopAddr("testaddr_1");
		shop.setShopImg("testImg_1");
		shop.setLastEditTime(new Date());
		int effectNum = shopMapper.updateShop(shop);
		assertEquals(1, effectNum);
	}
}

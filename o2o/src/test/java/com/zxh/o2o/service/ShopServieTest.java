package com.zxh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxh.o2o.BaseTest;
import com.zxh.o2o.dto.ImageHolder;
import com.zxh.o2o.dto.ShopExecution;
import com.zxh.o2o.entity.Area;
import com.zxh.o2o.entity.PersonInfo;
import com.zxh.o2o.entity.Shop;
import com.zxh.o2o.entity.ShopCategory;
import com.zxh.o2o.enums.ShopStateEnum;
import com.zxh.o2o.exceptions.ShopOperationException;

public class ShopServieTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	@Ignore
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(2L);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 1, 2);
		System.out.println("店铺列表数" + se.getShopList().size());
		System.out.println("店铺总数" + se.getCount());
	}
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException,FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopName("修改后的店铺名称");
		File shopImg = new File("C:/Users/Administrator/Desktop/img/basen.png");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imgeHolder = new ImageHolder("basen.png",is);
		ShopExecution  ShopExecution =  shopService.modifyShop(shop, imgeHolder);
		System.out.println("新的图片地址：" + ShopExecution.getShop().getShopImg());
		//assertEquals("修改后的店铺名称", ShopExecution.getShop().getShopName());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopName("testName_serv");
		shop.setShopCategory(shopCategory);
		shop.setShopDesc("testdesc_serv_1");
		shop.setShopAddr("testaddr_serv_1");
		shop.setPhone("testphone");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("C:/Users/Administrator/Desktop/img/zhuli.png");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imgeHolder = new ImageHolder(shopImg.getName(),is);
		ShopExecution se  = shopService.addShop(shop,imgeHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
}

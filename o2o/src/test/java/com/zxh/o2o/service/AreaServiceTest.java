package com.zxh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxh.o2o.BaseTest;
import com.zxh.o2o.entity.Area;

/**
 * AreaService层测试
 * @author zhaoxianhai
 * 2018年4月2日
 * @version 1.0
 */
public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("bbb", areaList.get(0).getAreaName());
	}
}

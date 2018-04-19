package com.zxh.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxh.o2o.BaseTest;
import com.zxh.o2o.entity.Area;


/**
 * AreaMapper测试
 * @author zhaoxianhai
 * 2018年4月2日
 * @version 1.0
 */
public class AreaMapperTest extends BaseTest{
	@Autowired
	private AreaMapper areaMapper;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaMapper.queryArea();
		//测试是否有两条记录
		assertEquals(4, areaList.size());
	}
	
}

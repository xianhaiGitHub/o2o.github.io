package com.zxh.o2o.dao;

import java.util.List;

import com.zxh.o2o.entity.Area;

public interface AreaMapper {
	/**
	 * 列出区域
	 * @return areaList
	 */
	List<Area> queryArea();
}
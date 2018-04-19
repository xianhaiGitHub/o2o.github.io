package com.zxh.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.o2o.entity.Area;
import com.zxh.o2o.service.AreaService;

import ch.qos.logback.classic.Logger;

/**
 * 
 * @author zhaoxianhai
 * 2018年4月2日
 * @version 1.0
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
	Logger log = (Logger) LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value ="/listarea",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> listArea() {
		log.info("==start==");
		long startTime = System.currentTimeMillis();
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<Area> list = new ArrayList<Area>();
		try{
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}catch(Exception e){
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		log.error("test error!");
		long endTime = System.currentTimeMillis();
		//记录方法执行所有的的时间,用来调优
		log.debug("costTime:[{}ms]",endTime-startTime);
		log.info("===end===");
		return modelMap;
		
	}
}

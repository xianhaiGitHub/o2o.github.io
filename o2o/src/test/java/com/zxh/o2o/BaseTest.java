package com.zxh.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring整合junit,junit启动时加载springIOC容器
 * @author zhaoxianhai
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({ "classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
	
}
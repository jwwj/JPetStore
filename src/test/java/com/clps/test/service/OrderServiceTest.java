package com.clps.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.demo.service.BannerdataService;
import com.clps.demo.service.OrderService;
import com.clps.demo.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void queryAccount() {
		LogUtil.logger.info(orderService.queryAccount("J2EE"));
	}
	
	@Test
	public void queryOrder() {
		LogUtil.logger.info(orderService.queryOrder("J2EE",0,1));
	}
	@Test
	public void queryInventory() {
		LogUtil.logger.info(orderService.queryInventory());
	}
	
	
}

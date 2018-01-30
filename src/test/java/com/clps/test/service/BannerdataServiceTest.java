package com.clps.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.demo.service.BannerdataService;
import com.clps.demo.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BannerdataServiceTest {

	@Autowired
	private BannerdataService bannerdataService;
	
	@Test
	public void querybanner() {
		LogUtil.logger.info(bannerdataService.querybanner("J2EE"));
	}
	
	@Test
	public void queryMyListOpf() {
		LogUtil.logger.info(bannerdataService.queryMyListOpf("J2EE"));
	}
	@Test
	public void queryMyList() {
		LogUtil.logger.info(bannerdataService.queryMyList("J2EE"));
	}
	
	
}

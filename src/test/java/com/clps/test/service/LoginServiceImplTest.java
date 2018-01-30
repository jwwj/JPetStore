package com.clps.test.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.demo.service.LoginService;
import com.clps.demo.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginServiceImplTest {
	@Autowired
	private LoginService loginService;
	@Test
	public void userLogin() {
		LogUtil.logger.info(loginService.userLogin("J2EE", "J2EE"));
		LogUtil.logger.info(loginService.userLogin("J2EE", "abcd"));
	}
	@Test
	public void querySignon() {
		LogUtil.logger.info(loginService.querySignon("J2EE").getPassword());
	}
	@Test
	public void queryProfile() {
		LogUtil.logger.info(loginService.queryProfile("J2EE").getFavcategory());
	}
}

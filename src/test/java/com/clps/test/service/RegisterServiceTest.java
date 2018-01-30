package com.clps.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.BannerdataService;
import com.clps.demo.service.RegisterService;
import com.clps.demo.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RegisterServiceTest {

	@Autowired
	private RegisterService registerService;
	
	@Test
	public void querybanner() {
		Signon signon = new Signon("Tom","123456");
		registerService.insertSigno(signon);
	}
	
	@Test
	public void queryMyListOpf() {
		Profile profile = new Profile("Tom","english");
		registerService.insertProfile(profile);
	}
	@Test
	public void queryMyList() {
		Account account = new Account();
		account.setUserid("Tom");
		account.setEmail("123456@qq.com");
		registerService.insertAccount(account);
	}
	
	
}

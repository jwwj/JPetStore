package com.clps.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.*;
import com.clps.demo.service.RegisterService;
import com.clps.demo.service.impl.RegisterServiceImpl;

/**
 * 注册响应
 * @author len
 *
 */
@Controller
public class RegisterAction {
	@Autowired
	private RegisterService registerService;
	private Account account;
	private Profile profile;
	private Signon signon;

	/**
	 * 注册新用户
	 * @return
	 */
	public String insert(){
		
//		System.out.println(signon.getUserid());
//		System.out.println(account.getPhone());
//		System.out.println(profile.getFavcategory());
//		System.out.println(profile.getBanneropt());
		
		if(profile.getBanneropt() == null){
			
			profile.setBanneropt((long)0);
		}
		if(profile.getMylistopt() == null){
			profile.setMylistopt((long)0);
		}
		profile.setUserid(signon.getUserid());
		
		account.setUserid(signon.getUserid());
		registerService.insertAccount(account);
		registerService.insertProfile(profile);
		registerService.insertSigno(signon);
			
		return "success";
	}
	
	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
	
	
	
	
}

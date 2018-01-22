package com.clps.demo.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.LoginService;
import com.clps.demo.service.ShoppingService;
import com.clps.demo.service.impl.LoginServiceImpl;
import com.clps.demo.service.impl.ShoppingServiceImpl;
import com.clps.demo.domain.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.sun.org.apache.xml.internal.utils.IntVector;

@Controller
public class LoginAction extends ActionSupport{

	@Autowired
	private LoginService loginService;
	@Autowired
	private ShoppingService shoppingService;
	
	private Signon signon;
	private Profile profile;
	private Account account;
	private long result;
	private Map<String,Item> itemMap;
	
	private int begin = 0;
	private int end = 10;
	public String login(){
		System.out.println(signon.getUserid());
		System.out.println(signon.getPassword());
		result = loginService.userLogin(signon.getUserid(),signon.getPassword());
		System.out.println(result + ",result");
		ActionContext.getContext().getSession().put("userid",signon.getUserid());
		if(result > 0){
			
			if(ActionContext.getContext().getSession().get("itemMap")!=null){
				
				itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
				List<Cart> cartlist = shoppingService.queryShopping(signon.getUserid(),begin*end,end);
				System.out.println(itemMap);
				System.out.println(cartlist);
				Cart cart = new Cart();
				Set<String> set = itemMap.keySet();
				for(String s : set){
					
					cart.setItem(itemMap.get(s));
					if(cartlist.contains(cart)){
						long count = itemMap.get(s).getCount() + shoppingService.count(s, signon.getUserid());
						System.out.println(count);
						shoppingService.updateQuantity((int)count, s, signon.getUserid());
					}else{
						int id=(int)(Math.random()*1000+1);
						cart.setId((long)id);
						cart.setSignon(signon);
						cart.setQuantity((long)itemMap.get(s).getCount());
						System.out.println(cart.getQuantity());
						shoppingService.saveShopping(cart);
					}
				}
				
				ActionContext.getContext().getSession().remove("itemMap");
			}
			
		}
		return "success";
		
	}
	public String queryInfoByUser(){
		
		
		signon = loginService.querySignon(signon.getUserid());
		profile = loginService.queryProfile(signon.getUserid());
		account = loginService.queryAccount(signon.getUserid());
		return "success";
	}
	
	public String saveProfile(){
		profile.setUserid(signon.getUserid());
		System.out.println(profile.getMylistopt());
		if(profile.getMylistopt() == null){
			
			profile.setMylistopt((long)0);
		}
		loginService.saveProfile(profile);
		return "success";
	}
	
	public String drop(){
		ActionContext.getContext().getSession().remove("userid");
		return "success";
		
	} 
	
	
	@JSON(serialize=false)
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}
	@JSON(serialize=false)
	public Signon getSignon() {
		return signon;
	} 

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public long getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@JSON(serialize=false)
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	@JSON(serialize=false)
	public ShoppingService getShoppingService() {
		return shoppingService;
	}
	public void setShoppingService(ShoppingServiceImpl shoppingService) {
		this.shoppingService = shoppingService;
	}
	
	@JSON(serialize=false)
	public Map<String, Item> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	
}

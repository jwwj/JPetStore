package com.clps.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.demo.domain.Cart;
import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.service.BannerdataService;
import com.clps.demo.service.ShoppingService;
import com.clps.demo.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ShoppingServiceTest {

	@Autowired
	private ShoppingService shoppingService;
	
	@Test
	public void saveShopping() {
		Cart cart = new Cart((long)277,new Item("EST-10",new Product("AV-SB-02",new Category("CATS"))));
		shoppingService.saveShopping(cart);
	}
	@Test
	public void queryShopping() {
		LogUtil.logger.info(shoppingService.queryShopping("J2EE",0,1));
	}
	
	@Test
	public void deleteShopping() {
		LogUtil.logger.info(shoppingService.deleteShopping("EST-10","J2EE"));
	}
	@Test
	public void queryCountShopping() {
		LogUtil.logger.info(shoppingService.queryCountShopping("EST-10","J2EE"));
	}
	@Test
	public void queryOneShopping() {
		LogUtil.logger.info(shoppingService.queryOneShopping("J2EE","EST-10"));
	}	

	
}

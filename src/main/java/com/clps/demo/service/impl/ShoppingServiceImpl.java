package com.clps.demo.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.ShoppingDao;
import com.clps.demo.dao.impl.ShoppingDaoImpl;
import com.clps.demo.domain.Cart;
import com.clps.demo.service.ShoppingService;


@Service
public class ShoppingServiceImpl implements ShoppingService{
	@Autowired
	private ShoppingDao shoppingDao;

	@Override
	public void saveShopping(Cart cart){
		
		shoppingDao.saveShopping(cart);
		
	}
	
	
	@Override
	public List<Cart> queryShopping(String userid,int begin,int end){
		
		return shoppingDao.queryShopping(userid,begin,end);
		
	}
	@Override
	public int deleteShopping(String itemid,String userid){
		
		return shoppingDao.deleteShopping(itemid, userid);
	}
	@Override
	public int updateQuantity(int quantity,String itemid,String userid){
		
		
		return shoppingDao.updateQuantity(quantity, itemid, userid);
	}
	
	@Override
	public long queryCountShopping(String itemid,String userid){
		
		return shoppingDao.queryCountShopping(itemid, userid);
	}
	@Override
	public Cart queryOneShopping(String userid,String itemid){
		
		
		return shoppingDao.queryOneShopping(userid, itemid);
		
	} 
	
	@Override
	public long count(String itemid,String userid){
		
		return shoppingDao.count(itemid, userid);
		
	}
	@Override
	public ShoppingDao getShoppingDao() {
		return shoppingDao;
	}
	@Override
	public void setShoppingDao(ShoppingDao shoppingDao) {
		this.shoppingDao = shoppingDao;
	}
	
	
}

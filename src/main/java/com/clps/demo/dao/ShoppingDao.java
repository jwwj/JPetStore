package com.clps.demo.dao;

import java.util.List;

import com.clps.demo.domain.Cart;

public interface ShoppingDao {

	public void saveShopping(Cart cart);
	
	public List<Cart> queryShopping(String userid,int begin,int end);
	
	public int deleteShopping(String itemid,String userid);
	
	public int updateQuantity(int quantity,String itemid,String userid);
	
	public long queryCountShopping(String itemid,String userid);
	
	public Cart queryOneShopping(String userid,String itemid);
	
	public long count(String itemid,String userid);
}

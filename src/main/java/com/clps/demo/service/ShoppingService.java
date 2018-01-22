package com.clps.demo.service;

import java.util.List;

import com.clps.demo.dao.ShoppingDao;
import com.clps.demo.dao.impl.ShoppingDaoImpl;
import com.clps.demo.domain.Cart;

public interface ShoppingService {

	/**
	 * 
	 * @param cart
	 */
	public void saveShopping(Cart cart);
	/**
	 * 
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Cart> queryShopping(String userid,int begin,int end);
	/**
	 * 
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	/**
	 * 
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int updateQuantity(int quantity,String itemid,String userid);
	/**
	 * 
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	/**
	 * 
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid);
	/**
	 * 
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);
	/**
	 * 
	 * @return
	 */
	public ShoppingDao getShoppingDao();
	/**
	 * 
	 * @param shoppingDao
	 */
	public void setShoppingDao(ShoppingDao shoppingDao);
}

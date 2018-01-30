package com.clps.demo.service;

import java.util.List;

import com.clps.demo.dao.ShoppingDao;
import com.clps.demo.dao.impl.ShoppingDaoImpl;
import com.clps.demo.domain.Cart;
/**
 * 购物车接口
 * @author len
 *
 */
public interface ShoppingService {

	/**
	 * 
	 * 保存购物车
	 * @param cart
	 */
	public void saveShopping(Cart cart);
	/**
	 * 查询用户的购物车列表
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Cart> queryShopping(String userid,int begin,int end);
	/**
	 * 删除购物车内的商品
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	/**
	 * 更新库存
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int updateQuantity(int quantity,String itemid,String userid);
	/**
	 * 查询商品总数
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	/**
	 * 获取购物车内的一个商品
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid);
	/**
	 * 购物车内的商品总数
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);
	public ShoppingDao getShoppingDao();
	public void setShoppingDao(ShoppingDao shoppingDao);
}

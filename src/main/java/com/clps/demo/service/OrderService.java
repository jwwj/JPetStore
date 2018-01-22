package com.clps.demo.service;

import java.util.List;

import com.clps.demo.dao.OrderDao;
import com.clps.demo.dao.impl.OrderDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;

public interface OrderService {

	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	/**
	 * 
	 * @param orders
	 */
	public void saveOrders(Orders orders);
	/**
	 * 
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	/**
	 * 
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus orderstatus);
	/**
	 * 
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	/**
	 * 
	 * @return
	 */
	public List<Inventory> queryInventory();
	/**
	 * 
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);
	/**
	 * 
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);
	/**
	 * 
	 * @return
	 */
	public OrderDao getOrderDao();
	/**
	 * 
	 * @param orderDao
	 */
	public void setOrderDao(OrderDao orderDao);
}

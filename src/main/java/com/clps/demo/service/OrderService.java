package com.clps.demo.service;

import java.util.List;

import com.clps.demo.dao.OrderDao;
import com.clps.demo.dao.impl.OrderDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;
/**
 * 订单接口
 * @author len
 *
 */
public interface OrderService {

	/**
	 * 获取用户详细信息
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	/**
	 * 保存订单信息
	 * @param orders
	 */
	public void saveOrders(Orders orders);
	/**
	 * 支付
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	/**
	 * 保存订单状态
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus orderstatus);
	/**
	 * 获取订单列表
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	/**
	 * 获取库存
	 * @return
	 */
	public List<Inventory> queryInventory();
	/**
	 * 更新库存
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);
	/**
	 * 获取一个订单
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);
	public OrderDao getOrderDao();
	public void setOrderDao(OrderDao orderDao);
}

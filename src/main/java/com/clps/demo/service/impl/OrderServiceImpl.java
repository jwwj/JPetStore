package com.clps.demo.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.OrderDao;
import com.clps.demo.dao.impl.OrderDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;
import com.clps.demo.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	@Override
	public Account queryAccount(String userid){
		
		return orderDao.queryAccount(userid);
		
	}
	@Override
	public void saveOrders(Orders orders){
		
		orderDao.saveOrder(orders);
		
	}
	@Override
	public void saveLineitem(Lineitem lineitem){
		
		orderDao.saveLineitem(lineitem);
		
	}
	@Override
	public void saveOrderstatus(Orderstatus orderstatus){
		
		orderDao.saveOrderstatus(orderstatus);
		
	}
	@Override
	public List<Orders> queryOrder(String userid,int begin,int end){
		
		return orderDao.queryOrder(userid,begin,end);
		
	}
	@Override
	public List<Inventory> queryInventory(){
		
		
		return orderDao.queryInventory();
		
	}
	@Override
	public void updateInventory(Inventory inventory){
		orderDao.updateInventory(inventory);
	}
	
	@Override
	public Orders queryOrdersOne(long orderid){
		
		return orderDao.queryOrdersOne(orderid);
	}
	@Override
	public OrderDao getOrderDao() {
		return orderDao;
	}
	@Override
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
}

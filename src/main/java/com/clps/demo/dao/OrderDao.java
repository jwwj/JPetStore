package com.clps.demo.dao;

import java.util.List;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;

public interface OrderDao {

	public Account queryAccount(String userid);
	
	public void saveOrder(Orders orders);
	
	public void saveLineitem(Lineitem lineitem);
	
	public void saveOrderstatus(Orderstatus orderstatus);
	
	public List<Orders> queryOrder(String userid,int begin,int end);
	
	public Orders queryOrdersOne(long orderid);
	
	public List<Inventory> queryInventory();
	
	public void updateInventory(Inventory inventory);
}

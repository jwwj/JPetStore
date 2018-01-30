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
 * �����ӿ�
 * @author len
 *
 */
public interface OrderService {

	/**
	 * ��ȡ�û���ϸ��Ϣ
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	/**
	 * ���涩����Ϣ
	 * @param orders
	 */
	public void saveOrders(Orders orders);
	/**
	 * ֧��
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	/**
	 * ���涩��״̬
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus orderstatus);
	/**
	 * ��ȡ�����б�
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	/**
	 * ��ȡ���
	 * @return
	 */
	public List<Inventory> queryInventory();
	/**
	 * ���¿��
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);
	/**
	 * ��ȡһ������
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);
	public OrderDao getOrderDao();
	public void setOrderDao(OrderDao orderDao);
}

package com.clps.demo.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clps.demo.domain.*;
import com.clps.demo.service.OrderService;
import com.clps.demo.service.ShoppingService;
import com.clps.demo.service.impl.OrderServiceImpl;
import com.clps.demo.service.impl.ShoppingServiceImpl;
/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     ���汣��        ����BUG
 *            ��Ի:
 *                   д��¥��д�ּ䣬д�ּ������Ա��
 *                   ������Աд�������ó��򻻾�Ǯ��
 *                   ����ֻ���������������������ߣ�
 *                   ��������ո��գ����������긴�ꡣ
 *                   ��Ը�������Լ䣬��Ը�Ϲ��ϰ�ǰ��
 *                   ���۱������Ȥ���������г���Ա��
 *                   ����Ц��߯��񲣬��Ц�Լ���̫����
 *                   ��������Ư���ã��ĸ���ó���Ա��
*/
/**
 * ������Ӧ
 * @author len
 *
 */
public class OrderAction {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShoppingService shoppingService;
	private Account account;
	private Signon signon;
	private Orders orders;
	private Lineitem lineitem;
	private Orderstatus orserstatus;
	private LineitemId lineitemId;
	private OrderstatusId orderstatusId;
	private List<Cart> cartlist;
	private List<Orders> orderslist;
	private int begin = 0;
	private int end = 4;
	/**
	 * ��ȡ�û���Ϣ
	 * @return
	 */
	public String queryAccount(){
//		System.out.println(signon.getUserid());
		account = orderService.queryAccount(signon.getUserid());
//		System.out.println(account.getPhone());
		return "success";
	}
	/**
	 * ���涩����Ϣ��֧��
	 * @return
	 */
	public String saveOrder(){
		//System.out.println(orders.getBilltolastname());
		//System.out.println(signon.getUserid()+",���");
		//System.out.println(account.getFirstname()+",����");
		account.setUserid(signon.getUserid());
		//System.out.println(account.getUserid());
		orders.setAccount(account);
		int id=(int)(Math.random()*9999+1);
		orders.setOrderid((long)id);
		orders.setOrderdate(new Date());
		//orders.setShipstate("123");
		//orders.setBillstate("123");
	
		lineitem = new Lineitem();
		lineitemId = new LineitemId();
		lineitemId.setOrders(orders);
		cartlist = shoppingService.queryShopping(signon.getUserid(),begin*end,end);
		double sum = 0;
		
		for(Cart cart2 : cartlist){
			double price = cart2.getItem().getListprice();
			long count = cart2.getQuantity();
			sum = sum + price * count;
			
		}
		
		orders.setTotalprice(sum);
		//System.out.println(sum+",sum");
		
		
		for(Cart cart : cartlist){
			
			lineitemId.setItemid(cart.getItem().getItemid());
			lineitem.setQuantity(cart.getQuantity());
			lineitem.setUnitprice(cart.getItem().getListprice());
			lineitem.setId(lineitemId);
		//	orderService.saveLineitem(lineitem);  
			orders.getLineitems().add(lineitem);
		}
		
		
		
		orserstatus = new Orderstatus();
		orderstatusId = new OrderstatusId();
		orderstatusId.setOrders(orders);
		orderstatusId.setLinenum((long)1);
		orserstatus.setId(orderstatusId);
		orserstatus.setTimestamp(orders.getOrderdate());
		orserstatus.setStatus("p");
	//	orderService.saveOrderstatus(orserstatus);
		orders.getOrderstatuses().add(orserstatus);
		orderService.saveOrders(orders);
		
		
		List<Inventory> inventorylist = orderService.queryInventory();
		for(Cart cart3 : cartlist){
			
			for(Inventory i:inventorylist){
				
				if(i.getItemid().equals(cart3.getItem().getItemid())){
					
					i.setQty(i.getQty()-cart3.getQuantity());
					orderService.updateInventory(i);
				}
			}
			
		}
	
	
		
		return "success";
	}
	/**
	 * ��ѯĳ��������Ϣ
	 * @return
	 */
	public String queryOrders(){
		account = orderService.queryAccount(signon.getUserid());
		cartlist = shoppingService.queryShopping(signon.getUserid(),begin*end,end);
		orders = orderService.queryOrdersOne(orders.getOrderid());
		return "success";
	}
	/**
	 * ������ʷ��¼
	 * @return
	 */
	public String historyOrders(){
		
		orderslist = orderService.queryOrder(signon.getUserid(),begin*end,end);
		return "success";
	}
	
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Lineitem getLineitem() {
		return lineitem;
	}

	public void setLineitem(Lineitem lineitem) {
		this.lineitem = lineitem;
	}

	public Orderstatus getOrserstatus() {
		return orserstatus;
	}

	public void setOrserstatus(Orderstatus orserstatus) {
		this.orserstatus = orserstatus;
	}

	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingServiceImpl shoppingService) {
		this.shoppingService = shoppingService;
	}

	public LineitemId getLineitemId() {
		return lineitemId;
	}

	public void setLineitemId(LineitemId lineitemId) {
		this.lineitemId = lineitemId;
	}

	public OrderstatusId getOrderstatusId() {
		return orderstatusId;
	}

	public void setOrderstatusId(OrderstatusId orderstatusId) {
		this.orderstatusId = orderstatusId;
	}

	public List<Cart> getCartlist() {
		return cartlist;
	}

	public void setCartlist(List<Cart> cartlist) {
		this.cartlist = cartlist;
	}

	public List<Orders> getOrderslist() {
		return orderslist;
	}

	public void setOrderslist(List<Orders> orderslist) {
		this.orderslist = orderslist;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	
	
}

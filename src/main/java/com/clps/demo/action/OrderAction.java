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
 *                     佛祖保佑        永无BUG
 *            佛曰:
 *                   写字楼里写字间，写字间里程序员；
 *                   程序人员写程序，又拿程序换酒钱。
 *                   酒醒只在网上坐，酒醉还来网下眠；
 *                   酒醉酒醒日复日，网上网下年复年。
 *                   但愿老死电脑间，不愿鞠躬老板前；
 *                   奔驰宝马贵者趣，公交自行程序员。
 *                   别人笑我忒疯癫，我笑自己命太贱；
 *                   不见满街漂亮妹，哪个归得程序员？
*/
/**
 * 订单响应
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
	 * 获取用户信息
	 * @return
	 */
	public String queryAccount(){
//		System.out.println(signon.getUserid());
		account = orderService.queryAccount(signon.getUserid());
//		System.out.println(account.getPhone());
		return "success";
	}
	/**
	 * 保存订单信息即支付
	 * @return
	 */
	public String saveOrder(){
		//System.out.println(orders.getBilltolastname());
		//System.out.println(signon.getUserid()+",编号");
		//System.out.println(account.getFirstname()+",姓名");
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
	 * 查询某个订单信息
	 * @return
	 */
	public String queryOrders(){
		account = orderService.queryAccount(signon.getUserid());
		cartlist = shoppingService.queryShopping(signon.getUserid(),begin*end,end);
		orders = orderService.queryOrdersOne(orders.getOrderid());
		return "success";
	}
	/**
	 * 订单历史记录
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

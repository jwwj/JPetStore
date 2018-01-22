package com.clps.demo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import com.clps.demo.domain.Cart;
import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.CategoryService;
import com.clps.demo.service.ShoppingService;
import com.opensymphony.xwork2.ActionContext;

public class ShoppingAction extends ActionSupport{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShoppingService shoppingService;
	private Category category;
	private Product product;
	private Item item;
	private Long qty;
	private Signon signon;
	private Cart cart;
	private List<Cart> listcart;
	private List<Item> itemlist;
	private int begin = 0;
	private int end = 10;
	private Map<String,Integer> cartMap; 
	private Map<String,Item> itemMap;
	private List<Product> productlist;
	private Double sumPrice;
	private Profile profile;
	

	public String queryShopping(){
		System.out.println(signon.getUserid() + "userid");
	
		if(signon.getUserid().equals("null")){
			item = categoryService.queryItemTwo(item.getItemid());
			itemlist = (List<Item>) ActionContext.getContext().getSession().get("itemlist");
			if(itemlist == null){
				itemlist = new ArrayList<Item>();
			}
			System.out.println("----");
			qty = categoryService.queryInventory(item.getItemid());
		
			
			itemlist.add(item);
			
			ActionContext.getContext().getSession().put("itemlist",itemlist);
			ActionContext.getContext().getSession().put("qty",qty);
			//------------------------------------------------
			cartMap = (Map<String, Integer>) ActionContext.getContext().getSession().get("cartMap");
			itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
			if(cartMap == null){
				
				cartMap = new HashMap<String, Integer>();
			}
			if(itemMap == null){
				itemMap = new HashMap<String, Item>();
			}
			
			
			if(cartMap.containsKey(item.getItemid())){
				
				cartMap.put(item.getItemid(), cartMap.get(item.getItemid())+1);
				item.setCount(cartMap.get(item.getItemid())+1);
			}else{
				
				cartMap.put(item.getItemid(), 1);
				item.setCount(1);

			}
			itemMap.put(item.getItemid(), item);
			ActionContext.getContext().getSession().put("cartMap",cartMap);
			ActionContext.getContext().getSession().put("itemMap",itemMap);
			
		}else{
			
			System.out.println("11");
			qty = categoryService.queryInventory(item.getItemid());
			item = categoryService.queryItemTwo(item.getItemid());
			System.out.println(item.getItemid());
			System.out.println(qty);
			if(shoppingService.queryCountShopping(item.getItemid(), signon.getUserid()) > 0){
				cart = shoppingService.queryOneShopping(signon.getUserid(), item.getItemid());
				
				shoppingService.updateQuantity(cart.getQuantity().intValue() + 1, item.getItemid(), signon.getUserid());
				System.out.println(cart.getQuantity());
			}else{
				
				cart = new Cart();
				int id=(int)(Math.random()*1000+1);
				cart.setId((long)id);
				cart.setItem(item);
				cart.setSignon(signon);
				cart.setQuantity((long)1);

				shoppingService.saveShopping(cart);
				
			}
			
			
		}
			
		return "success";
	}
	
	public String deleteShopping(){
		
		
		if("0".equals(signon.getUserid())){
			System.out.println("wu");
			System.out.println(item.getItemid() + ",heheheh");
			Map<String,Item> itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
			System.out.println(itemMap);
			itemMap.remove(item.getItemid());
			ActionContext.getContext().getSession().put("itemMap", itemMap);
			return "success";
			
			
		}else{
			
			System.out.println("you");
			System.out.println(item.getItemid());
			System.out.println(signon.getUserid());
			int result = shoppingService.deleteShopping(item.getItemid(), signon.getUserid());
			if(result > 0){
				
				return "success";
			}else{
				
				return "error";
			}
		}
		
	}
	
	public String queryShoppingTwo(){
		category = new Category();
		category.setCatid("CATS");
		productlist = categoryService.query(category,0,10);
		profile = categoryService.queryProfile(signon.getUserid());
		listcart = shoppingService.queryShopping(signon.getUserid(),begin*end,end);
		System.out.println(signon.getUserid());
		return "success";
	}
	
	public String saveCount(){
		if("0".equals(signon.getUserid())){
			System.out.println(item.getCount());
			System.out.println(item.getItemid());
			itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
			
			Item item2 = itemMap.get(item.getItemid());
			item2.setCount(item.getCount());
			itemMap.put(item2.getItemid(),item2);
			ActionContext.getContext().getSession().put("itemMap",itemMap);
			System.out.println(itemMap.get(item2.getItemid()).getCount());
		}else{
			System.out.println(item.getListprice() * item.getCount());
			shoppingService.updateQuantity(item.getCount(), item.getItemid(), signon.getUserid());
			sumPrice = item.getListprice() * item.getCount();
			System.out.println(sumPrice);
		}
		return "success";
	}
	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	@JSON(serialize=false)
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@JSON(serialize=false)
	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}
	@JSON(serialize=false)
	public List<Cart> getListcart() {
		return listcart;
	}

	public void setListcart(List<Cart> listcart) {
		this.listcart = listcart;
	}
	@JSON(serialize=false)
	public Map<String, Integer> getCartMap() {
		return cartMap;
	}
	
	public void setCartMap(Map<String, Integer> cartMap) {
		this.cartMap = cartMap;
	}
	@JSON(serialize=false)
	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
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

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	
	
	
	
}

package com.clps.demo.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.*;
import com.clps.demo.service.CategoryService;


@Controller
public class CategoryAction {

	@Autowired
	private CategoryService categoryService;
	
	private List<Product> productlist;
	private Category category;
	private int begin = 0;
	private int end = 2;
	
	private Product product;
	private List<Item> itemlist;

	private Long qty;
	private Item item;
	
	private String value; //模糊查询前台返回的值
	
	public String queryProduce(){
		
		productlist = categoryService.query(category,begin*end,end);
		System.out.println("CategoryAction.queryProduce");
		return "success";
	}
	public String queryItem(){
		
		itemlist = categoryService.queryItem(product.getProductid());
		System.out.println(itemlist);
		for(Item i : itemlist){
			
			System.out.println(i.getAttr1());
		}
		return "success";
	}
	//查询库存
	public String queryQty(){
	
		qty = categoryService.queryInventory(item.getItemid());
		item = categoryService.queryItemTwo(item.getItemid());
		return "success";
	}
	
	//模糊查询
	public String queryLike() throws UnsupportedEncodingException{
		System.out.println(value);
		value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
		productlist = categoryService.queryLike(value,begin*end,end);
		if(!productlist.isEmpty()) {
		System.out.println(productlist.get(0));
		return "success";
		}else return "error";
	}
//	public String queryLike() throws UnsupportedEncodingException{
//		System.out.println(value);
//		value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
//		productlist = categoryService.queryLike(value,begin*end,end);
//		System.out.println(productlist.get(0));
//		return "success";
//		
//	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Item> getItemlist() {
		return itemlist;
	}
	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}

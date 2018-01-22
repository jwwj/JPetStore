package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private String catid;
	private String name;
	private String descn;
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String catid) {
		this.catid = catid;
	}

	/** full constructor */
	public Category(String catid, String name, String descn, Set products) {
		this.catid = catid;
		this.name = name;
		this.descn = descn;
		this.products = products;
	}

	// Property accessors

	public String getCatid() {
		return this.catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}
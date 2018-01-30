package com.clps.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.demo.domain.Category;
import com.clps.demo.service.BannerdataService;
import com.clps.demo.service.CategoryService;
import com.clps.demo.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void query() {
		Category category = new Category("CATS");
		LogUtil.logger.info(categoryService.query(category,0,1));
	}
	
	@Test
	public void queryItem() {
		LogUtil.logger.info(categoryService.queryItem("J2EE"));
	}
	@Test
	public void queryInventory() {
		LogUtil.logger.info(categoryService.queryInventory("J2EE"));
	}
	
	@Test
	public void queryItemTwo() {
		LogUtil.logger.info(categoryService.queryItemTwo("J2EE"));
	}
	@Test
	public void queryLike() {
		LogUtil.logger.info(categoryService.queryLike("AV-CB-01",0,1));
	}
	@Test
	public void queryProfile() {
		LogUtil.logger.info(categoryService.queryProfile("J2EE"));
	}
	
}

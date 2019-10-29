package com.hky.onlineshop.dao;


import static org.junit.Assert.assertEquals;

import java.com.hky.onlineshop.dao.ShopCategoryDao;
import java.com.hky.onlineshop.entity.ShopCategory;
import java.util.Date;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory(){
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println("parent_id=null的记录数：" + shopCategoryList.size());
	}
	
	@Test
	@Ignore
	public void testAInsertShopCategory(){
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryName("美食");
		sc.setShopCategoryDesc("特色小吃");
		sc.setShopCategoryImg("test");
		sc.setWeight(3);
		sc.setCreateTime(new Date());
		sc.setLastEditTime(new Date());
		int effectedNum = shopCategoryDao.insertShopCategory(sc);
		assertEquals(1, effectedNum);
		
		ShopCategory sc1 = new ShopCategory();
		sc1.setShopCategoryName("兰州拉面");
		sc1.setShopCategoryDesc("正宗兰州拉面");
		sc1.setShopCategoryImg("test");
		sc1.setWeight(1);
		sc1.setCreateTime(new Date());
		sc1.setLastEditTime(new Date());
		sc1.setParent(sc);
		effectedNum = shopCategoryDao.insertShopCategory(sc1);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testBUpdateShopCategory(){
		
	}

}

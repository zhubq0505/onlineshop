package com.hky.onlineshop.dao;

import static org.junit.Assert.assertEquals;

import java.com.hky.onlineshop.dao.ShopDao;
import java.com.hky.onlineshop.entity.Area;
import java.com.hky.onlineshop.entity.Shop;
import java.com.hky.onlineshop.entity.ShopCategory;
import java.com.hky.onlineshop.entity.UserInfo;
import java.util.Date;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		UserInfo owner = new UserInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);

		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("888888");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 1L;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId:" + shop.getArea().getAreaId());
		System.out.println("areaName:" + shop.getArea().getAreaName());

	}
	
	@Test
	@Ignore
	public void testQueryShopList(){
		Shop shopCondition = new Shop();
		UserInfo user = new UserInfo();
		user.setUserId(1L);
		shopCondition.setOwner(user);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 3);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("列表结果数：" + shopList.size());
		System.out.println("查询结果数：" + count);
		
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		shopList = shopDao.queryShopList(shopCondition, 0, 2);
		count = shopDao.queryShopCount(shopCondition);
		System.out.println("新列表结果数：" + shopList.size());
		System.out.println("新查询结果数：" + count);
	}
}

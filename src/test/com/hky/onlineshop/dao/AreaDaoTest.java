package com.hky.onlineshop.dao;

import static org.junit.Assert.*;

import java.com.hky.onlineshop.dao.AreaDao;
import java.com.hky.onlineshop.entity.Area;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;




public class AreaDaoTest extends BaseTest {
	@Autowired
	@Qualifier("areaDao")
	private AreaDao areaDao;
	
	@Test
	@Ignore
	public void testQueryArea(){
		List<Area> areaList = areaDao.queryArea();
		assertEquals(4, areaList.size());
	}

}

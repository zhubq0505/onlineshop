package com.hky.onlineshop.service;

import static org.junit.Assert.assertEquals;

import java.com.hky.onlineshop.entity.Area;
import java.com.hky.onlineshop.service.AreaService;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	
	@Test
	@Ignore
	public void testGetAreaList(){
		List<Area> areaList = areaService.getAreaList();
		assertEquals("东苑", areaList.get(0).getAreaName());
	}

}

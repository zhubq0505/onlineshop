package com.hky.onlineshop.service.Impl;

import com.hky.onlineshop.dao.AreaDao;
import com.hky.onlineshop.entity.Area;
import com.hky.onlineshop.service.AreaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}
	
}

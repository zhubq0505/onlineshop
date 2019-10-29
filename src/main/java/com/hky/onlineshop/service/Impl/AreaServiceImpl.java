package java.com.hky.onlineshop.service.Impl;

import java.com.hky.onlineshop.dao.AreaDao;
import java.com.hky.onlineshop.entity.Area;
import java.com.hky.onlineshop.service.AreaService;
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

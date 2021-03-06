package com.hky.onlineshop.service.Impl;

import com.hky.onlineshop.dao.HeadLineDao;
import com.hky.onlineshop.entity.HeadLine;
import com.hky.onlineshop.service.HeadLineService;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Autowired
	private HeadLineDao headLineDao;

	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {
		return headLineDao.queryHeadLineList(headLineCondition);
	}

}

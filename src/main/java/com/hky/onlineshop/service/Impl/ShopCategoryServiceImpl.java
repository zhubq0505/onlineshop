package com.hky.onlineshop.service.Impl;

import com.hky.onlineshop.dao.ShopCategoryDao;
import com.hky.onlineshop.entity.ShopCategory;
import com.hky.onlineshop.service.ShopCategoryService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}

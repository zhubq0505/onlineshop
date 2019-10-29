package com.hky.onlineshop.service;

import com.hky.onlineshop.entity.ShopCategory;
import java.util.List;



public interface ShopCategoryService {	
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}

package java.com.hky.onlineshop.service;

import java.com.hky.onlineshop.entity.ShopCategory;
import java.util.List;



public interface ShopCategoryService {	
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}

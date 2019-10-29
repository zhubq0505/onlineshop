package com.hky.onlineshop.service;


import com.hky.onlineshop.dto.ImageHolder;
import com.hky.onlineshop.dto.ShopExecution;
import com.hky.onlineshop.entity.Shop;
import com.hky.onlineshop.exceptions.ShopOperationException;

public interface ShopService {
	/**
	 * 根据shopCondition分页查询返回结果列表
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
	/**
	 * 注册店铺信息，包括图片处理
	 * @param shop
	 * @param thumbnail:缩略图
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	/**
	 * 通过shopId获取店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息，包括对图片的处理
	 * @param shop
	 * @param thumbnail:缩略图
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	
}

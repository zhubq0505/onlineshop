package com.hky.onlineshop.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hky.onlineshop.entity.Product;
import java.util.List;

@Repository
@Mapper
public interface ProductDao {
	
	/**
	 * 获取商品列表并分页，商品名（模糊）、商品状态、店铺Id、商品类别
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition,
								   @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
	
	/**
	 * 查询对应的商品总数
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);
	
	/**
	 * 插入商品
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);
	
	/**
	 * 通过productId查询唯一的商品信息
	 * @param productId
	 * @return
	 */
	Product queryProductById(long productId);

	/**
	 * 更新商品信息
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);
	
	/**
	 * 删除商品类别之前，将商品的商品类别ID置为NULL
	 * @param productCategoryId
	 * @return
	 */
	int updateProductCategoryToNull(@Param("productCategoryId") Long productCategoryId);
}

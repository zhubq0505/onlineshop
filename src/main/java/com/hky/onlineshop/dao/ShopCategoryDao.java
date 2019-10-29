package java.com.hky.onlineshop.dao;

import java.com.hky.onlineshop.entity.ShopCategory;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ShopCategoryDao {
	/**
	 * 根据传入的查询条件返回店铺类别列表
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
	
	/**
	 * 根据shopCategoryId返回唯一的店铺类别
	 * @param shopCategoryId
	 * @return
	 */
	ShopCategory queryShopCategoryById(long shopCategoryId);
	
	/**
	 * 根据传入的Id列表查询店铺类别信息
	 * @param shopCategoryIdList
	 * @return
	 */
	List<ShopCategory> queryShopCategoryByIds(List<Long> shopCategoryIdList);

	/**
	 * 插入店铺类别信息
	 * @param shopCategory
	 * @return
	 */
	int insertShopCategory(ShopCategory shopCategory);
	
	/**
	 * 更新店铺类别信息
	 * @param shopCategory
	 * @return
	 */
	int updateShopCategory(ShopCategory shopCategory);

	/**
	 * 删除店铺类别
	 * @param shopCategoryId
	 * @return
	 */
	int deleteShopCategory(long shopCategoryId);
	
	/**
	 * 批量删除店铺类别
	 * @param shopCategoryIdList
	 * @return
	 */
	int batchDeleteShopCategory(List<Long> shopCategoryIdList);
}

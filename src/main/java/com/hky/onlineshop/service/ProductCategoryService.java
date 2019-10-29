package java.com.hky.onlineshop.service;

import java.com.hky.onlineshop.dto.ProductCategoryExecution;
import java.com.hky.onlineshop.entity.ProductCategory;
import java.com.hky.onlineshop.exceptions.ProductCategoryOperationException;
import java.util.List;



public interface ProductCategoryService {
	/**
	 * 查询指定某个店铺下的所有商品类别
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	
	/**
	 * 
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
		throws ProductCategoryOperationException;
	
	/**
	 * 将此类别下的商品里的类别id置为空，再删除该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
		throws ProductCategoryOperationException;
}

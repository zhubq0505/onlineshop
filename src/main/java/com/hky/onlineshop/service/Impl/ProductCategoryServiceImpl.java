package java.com.hky.onlineshop.service.Impl;

import java.com.hky.onlineshop.dao.ProductCategoryDao;
import java.com.hky.onlineshop.dao.ProductDao;
import java.com.hky.onlineshop.dto.ProductCategoryExecution;
import java.com.hky.onlineshop.entity.ProductCategory;
import java.com.hky.onlineshop.enums.ProductCategoryStateEnum;
import java.com.hky.onlineshop.exceptions.ProductCategoryOperationException;
import java.com.hky.onlineshop.service.ProductCategoryService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}

	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new ProductCategoryOperationException("店铺类别创建失败");
				} else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException("batchAddProductCategory error:" + e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
		}
	}

	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		// 将此商品类别下的商品的类别Id置为空
		try{
			int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
			if(effectedNum < 0){
				throw new ProductCategoryOperationException("商品类别更新失败");
			}
		}catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
		}
		
		try{
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if(effectedNum <= 0){
				throw new ProductCategoryOperationException("商品类别删除失败");
			}else{
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}
		}catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
		}
	}
}

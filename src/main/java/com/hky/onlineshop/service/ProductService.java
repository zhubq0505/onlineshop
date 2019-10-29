package java.com.hky.onlineshop.service;

import java.com.hky.onlineshop.dto.ImageHolder;
import java.com.hky.onlineshop.dto.ProductExecution;
import java.com.hky.onlineshop.entity.Product;
import java.com.hky.onlineshop.exceptions.ProductOperationException;
import java.util.List;


public interface ProductService {
	/**
	 * 查询商品列表并分页，商品名，商品状态，店铺Id，商品类别
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
	
	/**
	 * 添加商品及图片处理
	 * @param product
	 * @param thumbnail:缩略图
	 * @param productImgHolderList：详情图
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> productImgHolderList) throws ProductOperationException;
	
	/**
	 * 通过商品Id查询唯一的商品信息
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);
	
	/**
	 * 修改商品信息及图片处理
	 * @param product
	 * @param thumbnail
	 * @param productImgHolderList
	 * @return
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
		throws ProductOperationException;
}

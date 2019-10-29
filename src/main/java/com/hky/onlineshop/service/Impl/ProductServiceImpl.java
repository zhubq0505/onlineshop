package java.com.hky.onlineshop.service.Impl;

import java.com.hky.onlineshop.dao.ProductDao;
import java.com.hky.onlineshop.dao.ProductImgDao;
import java.com.hky.onlineshop.dto.ImageHolder;
import java.com.hky.onlineshop.dto.ProductExecution;
import java.com.hky.onlineshop.entity.Product;
import java.com.hky.onlineshop.entity.ProductImg;
import java.com.hky.onlineshop.enums.ProductStateEnum;
import java.com.hky.onlineshop.exceptions.ProductOperationException;
import java.com.hky.onlineshop.service.ProductService;
import java.com.hky.onlineshop.util.ImageUtil;
import java.com.hky.onlineshop.util.PageCalculator;
import java.com.hky.onlineshop.util.PathUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;
	
	@Override
	@Transactional
	//1.处理缩略图，获取缩略图相对路径赋值给product
	//2.写入商品信息，获取productId
	//3.批量处理商品详情图
	//4.批量写入商品详情图列表
	public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException {
		if(product != null && product.getShop() != null && product.getShop().getShopId() != null){
			product.setCreatTime(new Date());
			product.setLastEditTime(new Date());
			product.setEnableStatus(1);
			if(thumbnail != null){
				addThumbnail(product, thumbnail);
			}
			try{
				//创建商品信息
				int effectedNum = productDao.insertProduct(product);
				if(effectedNum <= 0){
					throw new ProductOperationException("创建商品失败");
				}
			}catch (Exception e) {
				throw new ProductOperationException("创建商品失败:" + e.toString());
			}
			if(productImgHolderList != null && productImgHolderList.size() > 0){
				addProductImgList(product, productImgHolderList);
			}
			return new ProductExecution(ProductStateEnum.SUCESS, product);
		}else{
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}
	
	/**
	 * 添加缩略图
	 * @param product
	 * @param thumbnail
	 */
	private void addThumbnail(Product product, ImageHolder thumbnail){
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		String thumbnailAddr = ImageUtil.generateThumnail(thumbnail, dest);
		product.setImgAddr(thumbnailAddr);
	}
	
	/**
	 * 批量添加图片
	 * @param product
	 * @param productImgHolderList
	 */
	private void addProductImgList(Product product, List<ImageHolder> productImgHolderList){
		//获取图片存储路径
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		//遍历图片
		for(ImageHolder productImgHolder:productImgHolderList){
			String imgAddr = ImageUtil.generateNormalImg(productImgHolder, dest);
			ProductImg productImg = new ProductImg();
			productImg.setImgAddr(imgAddr);
			productImg.setProductId(product.getProductId());
			productImg.setCreateTime(new Date());
			productImgList.add(productImg);
		}
		if(productImgList.size() > 0){
			try{
				int effectedNum = productImgDao.batchInsertProductImg(productImgList);
				if(effectedNum <= 0){
					throw new ProductOperationException("创建商品详情图片失败");
				}
			}catch (Exception e) {
				throw new ProductOperationException("创建商品详情图片失败" + e.toString());
			}
		}
	}

	@Override
	public Product getProductById(long productId) {
		return productDao.queryProductById(productId);
	}

	@Override
	@Transactional
	//1.若缩略图参数有值，处理缩略图
	//若原先存在缩略图则先删除再添加新图，之后获取缩略图相对路径并赋值给product
	//2.若商品详情图列表参数有值，对商品详情图片列表进行同样的操作
	//3.将product_img下面的该商品原有的商品详情图记录全部删除
	//4.更新product信息
	public ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
			List<ImageHolder> productImgHolderList) throws ProductOperationException {
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			//设置默认属性
			product.setLastEditTime(new Date());
			if (thumbnail != null) {
				//获取原有信息
				Product tempProduct = productDao.queryProductById(product.getProductId());
				if (tempProduct.getImgAddr() != null) {
					ImageUtil.deleteFileOrPath(tempProduct.getImgAddr());
				}
				addThumbnail(product, thumbnail);
			}
			if (productImgHolderList != null && productImgHolderList.size() > 0) {
				deleteProductImgList(product.getProductId());
				addProductImgList(product, productImgHolderList);
			}
			try {
				int effectedNum = productDao.updateProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("更新商品信息失败");
				}
				return new ProductExecution(ProductStateEnum.SUCESS, product);
			} catch (Exception e) {
				throw new ProductOperationException("更新商品信息失败：" + e.toString());
			}
		}else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}
	
	/**
	 * 删除某个商品下的所有详情图
	 * @param productId
	 */
	private void deleteProductImgList(long productId){
		List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);
		for(ProductImg productImg : productImgList){
			ImageUtil.deleteFileOrPath(productImg.getImgAddr());
		}
		productImgDao.deleteProductImgByProductId(productId);
	}

	@Override
	public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize) {
		//计算记录起始行
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Product> productList = productDao.queryProductList(productCondition, rowIndex, pageSize);
		int count = productDao.queryProductCount(productCondition);
		ProductExecution pe = new ProductExecution();
		pe.setProductList(productList);
		pe.setCount(count);
		return pe;
	}
}

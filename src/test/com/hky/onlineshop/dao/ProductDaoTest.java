package com.hky.onlineshop.dao;

import static org.junit.Assert.assertEquals;

import com.hky.onlineshop.dao.ProductDao;
import com.hky.onlineshop.dao.ProductImgDao;
import com.hky.onlineshop.entity.Product;
import com.hky.onlineshop.entity.ProductCategory;
import com.hky.onlineshop.entity.ProductImg;
import com.hky.onlineshop.entity.Shop;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {
	@Autowired
	private ProductImgDao productImgDao;
	@Autowired
	private ProductDao productDao;
	
	@Test
	@Ignore
	public void testAInsertProduct() throws Exception{
		Shop shop1 = new Shop();
		shop1.setShopId(1L);
		ProductCategory pc1 = new ProductCategory();
		pc1.setProductCategoryId(1L);
		//初始化三个商品实例并添加进shopId为1的店铺里
		//同时商品类别Id也为1
		Product product1 = new Product();
		product1.setProductName("测试1");
		product1.setProductDesc("测试1Desc");
		product1.setImgAddr("test1");
		product1.setWeight(1);
		product1.setEnableStatus(1);
		product1.setCreatTime(new Date());
		product1.setLastEditTime(new Date());
		product1.setShop(shop1);
		product1.setProductCategory(pc1);
		
		Product product2 = new Product();
		product2.setProductName("测试2");
		product2.setProductDesc("测试2Desc");
		product2.setImgAddr("test2");
		product2.setWeight(1);
		product2.setEnableStatus(1);
		product2.setCreatTime(new Date());
		product2.setLastEditTime(new Date());
		product2.setShop(shop1);
		product2.setProductCategory(pc1);
		
		Product product3 = new Product();
		product3.setProductName("test3");
		product3.setProductDesc("测试2Desc");
		product3.setImgAddr("test3");
		product3.setWeight(1);
		product3.setEnableStatus(1);
		product3.setCreatTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pc1);
		int effectedNum = productDao.insertProduct(product1);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product2);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product3);
		assertEquals(1, effectedNum);
	}
	
	@Test
	@Ignore
	public void testBQueryProductList() throws Exception{
		Product productCondition = new Product();
		//分页查询
		List<Product> productList = productDao.queryProductList(productCondition, 0, 5);
		System.out.println("列表记录数：" + productList.size());
		int count = productDao.queryProductCount(productCondition);
		System.out.println("记录总数：" + count);
		//查询商品名称包含"测试"
		productCondition.setProductName("测试");
		count = productDao.queryProductCount(productCondition);
		System.out.println("测试商品记录总数：" + count);
		productList = productDao.queryProductList(productCondition, 0, 3);
		System.out.println("测试商品列表记录数：" + productList.size());
	}
	
	@Test
	@Ignore
	public void testCQueryProductByProductId() throws Exception{
		long productId = 1;
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setWeight(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(productId);
		
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setImgDesc("测试图片2");
		productImg2.setWeight(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(productId);
		
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
		System.out.println("插入行数：" + effectedNum);
		
		Product product = productDao.queryProductById(productId);
		assertEquals(2, product.getProductImgList().size());
		
		effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
		System.out.println("删除行数：" + effectedNum);
	}
	
	@Test
	@Ignore
	public void testDUpdateProduct() throws Exception{
		Product product = new Product();
		ProductCategory pc = new ProductCategory();
		Shop shop = new Shop();
		shop.setShopId(1L);
		pc.setProductCategoryId(2L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductName("商品1");
		product.setProductCategory(pc);
		int effectedNum = productDao.updateProduct(product);
		System.out.println("更新记录数：" + effectedNum);
	}
	
	@Test
	@Ignore
	public void testEUpdateProductCategoryToNull(){
		int effectedNum = productDao.updateProductCategoryToNull(2L);
		System.out.println("CategoryId=2, ShopId=1的商品数量：" + effectedNum);
	}
}

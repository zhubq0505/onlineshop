package com.hky.onlineshop.service;

import static org.junit.Assert.assertEquals;

import com.hky.onlineshop.dto.ImageHolder;
import com.hky.onlineshop.dto.ProductExecution;
import com.hky.onlineshop.entity.Product;
import com.hky.onlineshop.entity.ProductCategory;
import com.hky.onlineshop.entity.Shop;
import com.hky.onlineshop.enums.ProductStateEnum;
import com.hky.onlineshop.exceptions.ShopOperationException;
import com.hky.onlineshop.service.ProductService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductServiceTest extends BaseTest {
	@Autowired
	private ProductService productService;
	
	@Test
	@Ignore
	public void testAddProduct() throws ShopOperationException, FileNotFoundException{
		//创建shopId为1且productCategoryId为1的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1");
		product.setWeight(3);
		product.setCreatTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCESS.getState());
		//创建缩略图文件流
		File thumbnailFile = new File("F:/images/nazha.jpg");
		InputStream ins = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), ins);
		
		//创建两个商品详情图片文件流
		File productImg1 = new File("F:/images/beer.jpg");
		InputStream ins1 = new FileInputStream(productImg1);
		File productImg2 = new File("F:/images/cxk.jpg");
		InputStream ins2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgHolderList = new ArrayList<ImageHolder>();
		productImgHolderList.add(new ImageHolder(productImg1.getName(), ins1));
		productImgHolderList.add(new ImageHolder(productImg2.getName(), ins2));
		//添加商品并验证
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgHolderList);
		assertEquals(ProductStateEnum.SUCESS.getState(), pe.getState());
	}

	@Test
	public void testModifyProduct() throws ShopOperationException, FileNotFoundException{
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("发布商品1");
		product.setProductDesc("测试商品发布");
		//创建缩略图文件流
		File thumbnailFile = new File("F:/images/beer.jpg");
		InputStream ins = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), ins);
		//创建详情图文件流
		File productImg1 = new File("F:/images/milk.jpg");
		InputStream ins1 = new FileInputStream(productImg1);
		File productImg2 = new File("F:/images/caffee.jpg");
		InputStream ins2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgHolderList = new ArrayList<>();
		productImgHolderList.add(new ImageHolder(productImg1.getName(), ins1));
		productImgHolderList.add(new ImageHolder(productImg2.getName(), ins2));
				
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgHolderList);
		assertEquals(ProductStateEnum.SUCESS.getState(), pe.getState());
	}
}

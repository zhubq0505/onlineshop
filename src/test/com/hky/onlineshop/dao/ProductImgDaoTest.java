package com.hky.onlineshop.dao;

import static org.junit.Assert.assertEquals;

import com.hky.onlineshop.dao.ProductImgDao;
import com.hky.onlineshop.entity.ProductImg;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hky.onlineshop.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {
	@Autowired
	private ProductImgDao productImgDao;
	
	@Test
	public void testABatchInsertProductImg() throws Exception{
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("png1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setWeight(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(1L);
		
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("png2");
		productImg2.setImgDesc("测试图片2");
		productImg2.setWeight(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(1L);
		
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		System.out.println("插入记录数：" + effectedNum);
		assertEquals(2, effectedNum);
	}
	
	@Test
	public void testCDeleteProductImgByProductId() throws Exception{
		long productId = 1;
		int effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
		System.out.println("删除记录数：" + effectedNum);
	}
}

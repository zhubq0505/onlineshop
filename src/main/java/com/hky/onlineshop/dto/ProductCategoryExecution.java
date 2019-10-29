package com.hky.onlineshop.dto;

import com.hky.onlineshop.entity.ProductCategory;
import com.hky.onlineshop.entity.Shop;
import com.hky.onlineshop.enums.ProductCategoryStateEnum;
import java.util.List;

/**
 * 商品类别操作数据存储类
 * @author zbq
 *
 */
public class ProductCategoryExecution {
	// 结果状态
		private int state;
		// 状态标识
		private String stateInfo;
		// 店铺数量
		private int count;
		// 操作的shop（增删改店铺）
		private Shop shop;
		// shop列表（查询店铺）
		private List<ProductCategory> productCategoryList;
		
		public ProductCategoryExecution(){}
		
		//操作失败时使用的构造器
		public ProductCategoryExecution(ProductCategoryStateEnum stateEnum){
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}
		
		//操作成功时使用的构造器
		public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList){
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.productCategoryList = productCategoryList;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

		public String getStateInfo() {
			return stateInfo;
		}

		public void setStateInfo(String stateInfo) {
			this.stateInfo = stateInfo;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Shop getShop() {
			return shop;
		}

		public void setShop(Shop shop) {
			this.shop = shop;
		}

		public List<ProductCategory> getProductCategoryList() {
			return productCategoryList;
		}

		public void setProductCategoryList(List<ProductCategory> productCategoryList) {
			this.productCategoryList = productCategoryList;
		}
		
		
}

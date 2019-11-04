package com.hky.onlineshop.util;

public class PathUtil {
	private static String separator = System.getProperty("file.separator");
	/**
	 * 获取本地图片存放绝对路径
	 * @return
	 */
	public static String getImgBasePath(){
		String os = System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")){
			basePath="D:/images/";
		}else{
			basePath="/home/zbq/images/";
		}
		basePath = basePath.replace("/", separator);
		return basePath;
	}
	
	public static String getShopImagePath(long shopId){
		String imagePath = "upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", separator);
	}
}

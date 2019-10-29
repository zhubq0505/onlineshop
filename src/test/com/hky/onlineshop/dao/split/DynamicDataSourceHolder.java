package com.hky.onlineshop.dao.split;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class DynamicDataSourceHolder {
	private static Logger logger = (Logger) LoggerFactory.getLogger(DynamicDataSourceHolder.class);
	/**
	 * 变量在线程间隔离而在方法或类间共享
	 */
	private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
	public static final String DB_MASTER = "master";
	public static final String DB_SLAVE = "slave";
	
	public static String getDbType(){
		String db = contextHolder.get();
		if(db == null){
			db = DB_MASTER;
		}
		return db;
	}
	
	public static void setDbType(String str){
		logger.debug("所使用的数据源为：" + str);
		contextHolder.set(str);
	}
	
	/**
	 * 清理
	 */
	public static void clearDBType(){
		contextHolder.remove();
	}
}

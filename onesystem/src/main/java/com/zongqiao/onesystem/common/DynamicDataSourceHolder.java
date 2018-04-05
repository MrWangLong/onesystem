package com.zongqiao.onesystem.common;

public class DynamicDataSourceHolder {
	private static final String master = "master";

	private static final String slave = "slave";
	
	private static final String defaults = "default";

	private static final ThreadLocal<String> holder = new ThreadLocal<>();

	public static void putDataSourceKey(String key) {
		holder.set(key);
	}

	public static String getDataSourceKey() {

		return holder.get();
	}

	public static void markMaster() {

		putDataSourceKey(master);
	}

	public static void markSlave() {

		putDataSourceKey(slave);
	}
	
	public static void markDefault() {

		putDataSourceKey(defaults);
	}
	
	

}

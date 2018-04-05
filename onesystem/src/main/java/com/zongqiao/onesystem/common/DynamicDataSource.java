package com.zongqiao.onesystem.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
	
	private static boolean isDefault = false;
	
	public static void detemenieDefaultDataSource(){
		
		isDefault = true;
	}

	@Override
	protected Object determineCurrentLookupKey() {
        
		//使用默认数据库源
		if(isDefault){
		DynamicDataSourceHolder.markDefault();
		}
		//根据方法名读写分离
		return DynamicDataSourceHolder.getDataSourceKey();
	}

}

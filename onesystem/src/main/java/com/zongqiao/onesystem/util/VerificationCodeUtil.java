package com.zongqiao.onesystem.util;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
 * 验证码工具类
 * 
 * @author jkx
 *
 */
public class VerificationCodeUtil {
    //验证码
	private static String code;
	//验证码生成时间
	private static long time;
    //验证码工具类 
	private static VerificationCodeUtil verificationCodeUtil;
    //私有化构造器
	private VerificationCodeUtil() {

	}
    //实例化
	public static VerificationCodeUtil getInstance() {
        //懒汉式
		if(verificationCodeUtil == null){
			
			verificationCodeUtil = new VerificationCodeUtil();
		} 

		return verificationCodeUtil;
	}
    //获取验证码
	public String getVerificationCode() {

		// 只有在验证码无效的时候才重新生成验证码
		if (!isValid()) {
			code = RandomStringUtils.randomNumeric(6);
			// 重新设置验证码生成的时间
			time = new Date().getTime();
		}

		return code;
	}
    
	//验证码是否过期
	public boolean isValid() {
		//默认验证码没过期
		boolean flag = true;
		// 只有当前时间比验证码生成的时间大60s时,验证码失效
		long now = new Date().getTime();
		long spend = (now - time)/1000;
		if (spend > 60) {
			flag = false;
		}
		
		return flag;
	}
}

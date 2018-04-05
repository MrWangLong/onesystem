package com.zongqiao.onesystem.util;

import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 
 * 验证码工具类
 * 
 * @author jkx
 *
 */
public class VerificationCodeUtil {

	private static int code;
	private static long time;

	private static VerificationCodeUtil verificationCodeUtil;

	private VerificationCodeUtil() {

	}

	public static VerificationCodeUtil getInstance() {

		// 懒汉式
		if (verificationCodeUtil == null) {

			verificationCodeUtil = new VerificationCodeUtil();
		}

		return verificationCodeUtil;
	}

	public int getVerificationCode() {

		// 只有在验证码无效的时候才重新生成验证码
		if (!isValid()) {
			code = RandomUtils.nextInt(6);
			// 重新设置验证码生成的时间
			time = new Date().getTime();
		}

		return code;
	}

	public boolean isValid() {
		
		boolean flag = true;
		// 只有当前时间比验证码生成的时间大60s时,验证码失效
		long now = new Date().getTime();
		long spend = (now - time) / 60;
		if (spend > 60) {
			flag = false;
		}
		
		return flag;
	}
}

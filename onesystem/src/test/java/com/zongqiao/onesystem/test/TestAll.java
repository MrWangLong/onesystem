package com.zongqiao.onesystem.test;

import org.junit.Test;

import com.zongqiao.onesystem.util.VerificationCodeUtil;

public class TestAll {
  
public static void main(String[] args) {
	VerificationCodeUtil util = 	VerificationCodeUtil.getInstance();
	System.err.println(util + ":::" + util.getVerificationCode());
}
}

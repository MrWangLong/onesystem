package com.zongqiao.onesystem.test;

import com.zongqiao.onesystem.util.VerificationCodeUtil;

public class TestAll {
  
public static void main(String[] args) {
	
	
	Thread code1 = new Code();
	Thread code2 = new Code();
	Thread code3 = new Code();
	code1.start();
	code2.start();
	code3.start();
	
	
}
}

class  Code extends Thread{
	@Override
	public void run() {
		VerificationCodeUtil util = VerificationCodeUtil.getInstance();
		System.err.println(util + ":::" + util.getVerificationCode());
	}
} 

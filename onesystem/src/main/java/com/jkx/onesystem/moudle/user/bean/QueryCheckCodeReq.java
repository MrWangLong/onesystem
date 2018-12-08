package com.jkx.onesystem.moudle.user.bean;

import com.jkx.onesystem.common.bean.AppBaseReq;

public class QueryCheckCodeReq extends AppBaseReq {
	private static final long serialVersionUID = 1L;

	private String phoneNumber;// 电话号码

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

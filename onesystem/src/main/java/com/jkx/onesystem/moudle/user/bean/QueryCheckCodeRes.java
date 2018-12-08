package com.jkx.onesystem.moudle.user.bean;

import com.jkx.onesystem.common.bean.AppBaseRes;

public class QueryCheckCodeRes extends AppBaseRes {
	private static final long serialVersionUID = 1L;

	private String code;// 验证码

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

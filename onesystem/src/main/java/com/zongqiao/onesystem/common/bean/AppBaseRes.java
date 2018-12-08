package com.zongqiao.onesystem.common.bean;

import java.io.Serializable;

import com.zongqiao.onesystem.common.define.AppDefine;

public class AppBaseRes<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int retCode = AppDefine.SUCCESS_CODE;// 返回码

	private String retMsg = AppDefine.SUCCESS_MESSAGE;// 返回信息

	private T data;// 返回通用对象

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

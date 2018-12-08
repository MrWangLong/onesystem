package com.zongqiao.onesystem.common.bean;

import java.io.Serializable;

public class AppBaseReq implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private Long reqId;//请求id

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}
	
	
}

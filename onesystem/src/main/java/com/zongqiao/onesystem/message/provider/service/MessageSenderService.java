package com.zongqiao.onesystem.message.provider.service;

public interface MessageSenderService {
    /**
     * 发送消息
     * @param key
     * @param value
     */
	public void sendMessage(String key, Object value);
}

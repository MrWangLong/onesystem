package com.zongqiao.onesystem.message.listener;

import org.springframework.stereotype.Component;

@Component
public class SendEmailListener { 

	public void receiveMessage(String msg) {
		if (msg != null) {
			System.out.println("接收到消息：" + msg);
		}
	}

}

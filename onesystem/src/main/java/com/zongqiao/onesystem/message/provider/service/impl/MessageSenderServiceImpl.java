package com.zongqiao.onesystem.message.provider.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zongqiao.onesystem.message.provider.service.MessageSenderService;

@Service("messageSenderService")
public class MessageSenderServiceImpl implements MessageSenderService {

	@Autowired
	AmqpTemplate amqpTemplate;

	@Override
	public void sendMessage(String key, Object value) {

		amqpTemplate.convertAndSend(key, value);
	}

}

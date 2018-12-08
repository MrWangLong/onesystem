package com.zongqiao.onesystem.message.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

import net.sf.json.JSONObject;

public class RabbitmqLogListener implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message msg, Channel channel) throws Exception {
		try {
			System.out.println(msg.toString());
			// 接收消息
			JSONObject str = JSONObject.fromObject(new String(msg.getBody()));
			// 处理事务逻辑
			System.err.println("Mq receive message body :" + str.toString());
			// 确认消息
			channel.basicAck(msg.getMessageProperties().getDeliveryTag(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

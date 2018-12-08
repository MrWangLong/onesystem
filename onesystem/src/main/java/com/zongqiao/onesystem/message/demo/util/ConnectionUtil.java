package com.zongqiao.onesystem.message.demo.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
	 
    private static ConnectionFactory factory;
 
    private static  Channel channel;
 
    public static final String QUEUE_NAME = "cloud_attacking_dream";
 
    /*
    * 单例模式机制获取连接通道
    * */
    public static Channel initConnetion() throws IOException, TimeoutException {
        if (null == factory && null == channel) {
            factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672);
            factory.setUsername("guest");
            factory.setPassword("guest");
            Connection connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        }
        return channel;
    }
 
}

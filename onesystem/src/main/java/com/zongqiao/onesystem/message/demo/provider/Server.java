package com.zongqiao.onesystem.message.demo.provider;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.zongqiao.onesystem.message.demo.util.ConnectionUtil;

public class Server {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Channel channel = ConnectionUtil.initConnetion();
        for (int i =0; i < 100; i++) {
            String message = UUID.randomUUID().toString();
            channel.basicPublish("", ConnectionUtil.QUEUE_NAME, null, message.getBytes("UTF-8"));
            //定时发消息，效果更明显
            Thread.sleep(10000);
        }
    }
    
}
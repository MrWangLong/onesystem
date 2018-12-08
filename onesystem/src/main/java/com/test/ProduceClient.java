package com.test;

public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient mqClient = new MqClient();
        mqClient.produce("hello world!");
    }
}

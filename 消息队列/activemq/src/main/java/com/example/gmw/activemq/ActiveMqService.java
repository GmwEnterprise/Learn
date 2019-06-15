package com.example.gmw.activemq;

public interface ActiveMqService {

    void sendMessage(String message);

    void receiveMessage(String message);
}

package com.example.gmw.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ActiveMqServiceImpl implements ActiveMqService {
    private final JmsTemplate jmsTemplate;

    public ActiveMqServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendMessage(String message) {
        log.info("发送消息【{}】", message);
        jmsTemplate.convertAndSend(message);
    }

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMessage(String message) {
        log.info("接收消息【{}】", message);
    }
}

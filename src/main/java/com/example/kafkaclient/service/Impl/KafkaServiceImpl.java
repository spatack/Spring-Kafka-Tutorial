package com.example.kafkaclient.service.Impl;

import com.example.kafkaclient.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void send(String message) {
        String TOPIC = "MyTopic";
        kafkaTemplate.send(TOPIC, message); //send a message with topic: MyTopic
    }

    @KafkaListener(topics = "MyTopic")
    public void consume(String message) {
        System.out.println("Consume Message From MyTopic : "+message); //consume message from topic: MyTopic and print message
    }
}

package com.example.kafkaclient.service;

/**
 * KafkaService
 */
public interface KafkaService {
    /**
     * send message
     */
    void send(String message);
}

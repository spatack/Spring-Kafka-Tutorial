package com.example.kafkaclient.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

/**
 * Kafka config beans
 */
@Configuration
public class KafkaConfig {

    /**
     * Producer Factory Bean
     * @param properties KafkaProperties
     * @return DefaultKafkaProducerFactory
     */
    @Bean
    public ProducerFactory producerFactory(KafkaProperties properties) {
        Map<String, Object> producerProperties = properties.buildProducerProperties();
        /* if we use SSL and the client needs validate,
         then the keystore location and truststore location config should add here  */
        producerProperties.put("ssl.keystore.location", "client.keystore.jks");
        producerProperties.put("ssl.truststore.location", "client.truststore.jks");
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }

    /**
     * Consumer Factory Bean
     * @param properties KafkaProperties
     * @return DefaultKafkaConsumerFactory
     */
    @Bean
    public ConsumerFactory consumerFactory(KafkaProperties properties) {
        Map<String, Object> consumerProperties = properties.buildConsumerProperties();
        /*  same as producerFactory */
        consumerProperties.put("ssl.keystore.location", "client.keystore.jks");
        consumerProperties.put("ssl.truststore.location", "client.truststore.jks");
        return new DefaultKafkaConsumerFactory<>(consumerProperties);
    }
}

package com.example.kafkaclient.controller;

import com.example.kafkaclient.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaService kafkaService;

    /**
     * publish message
     * @param message message
     * @return ok
     */
    @GetMapping("/kafka/producer/publish")
    public ResponseEntity publishMessage(@RequestParam String message) {
        kafkaService.send(message);
        return ResponseEntity.ok("OK");
    }

}

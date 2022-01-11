package com.example.staffservice.service.impl;

import com.example.staffservice.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/11 2:16 下午
 */
@Service
public class KafkaServiceImpl implements KafkaService {

    KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void generateUser(String userId) {
        kafkaTemplate.send("user", userId);
    }

    @Override
    public void generateTask(String userId) {
        kafkaTemplate.send("task", userId);
    }

    @Autowired
    private void setKafkaTemplate(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
}

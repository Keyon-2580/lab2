package com.example.userservice.kafka;

import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/11 2:33 下午
 */
@Component
@Slf4j
public class KafkaConsumer {

    UserService userService;

    @KafkaListener(topics = "user")
    public void generateUser(ConsumerRecord<?, ?> record){

        String userId = record.value().toString();
        log.info("get kafkaMessage topic is" + record.topic() + "message is" + record.value().toString());
        userService.registerUser(userId);


    }

    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
    }
}

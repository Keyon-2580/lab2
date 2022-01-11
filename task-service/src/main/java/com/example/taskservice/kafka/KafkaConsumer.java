package com.example.taskservice.kafka;

import com.example.taskservice.domin.dbo.Task;
import com.example.taskservice.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/11 2:25 下午
 */
@Component
@Slf4j
public class KafkaConsumer {

    TaskService taskService;

    @KafkaListener(topics = "task")
    public void generateTask(ConsumerRecord<?,?>record) throws IOException {
        String userId = record.value().toString();
        log.info("get kafkaMessage topic is" + record.topic() + "message is" + record.value().toString());
        taskService.generateTask(userId);

    }

    @Autowired
    private void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }
}

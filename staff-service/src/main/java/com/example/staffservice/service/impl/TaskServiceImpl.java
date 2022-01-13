package com.example.staffservice.service.impl;

import com.example.common.domin.ResponseBean;
import com.example.staffservice.service.KafkaService;
import com.example.staffservice.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/11 2:45 下午
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    KafkaService kafkaService;
    @Override
    public ResponseBean generateTask(String userId) {
        kafkaService.generateTask(userId);
        log.info("task-service error, staff-service send kafka message");
        return null;
    }

    @Override
    public ResponseBean<Integer> getTaskStatus(String userId) {
        return null;
    }

    @Autowired
    private void setKafkaService(KafkaService kafkaService){
        this.kafkaService = kafkaService;
    }
}

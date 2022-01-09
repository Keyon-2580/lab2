package com.example.taskservice.service;

import com.example.taskservice.dao.TaskDao;
import com.example.taskservice.domin.dbo.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 3:15 下午
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

    TaskDao taskDao;

    @Autowired
    private void setTaskDao(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    @Override
    public void updateStatus(String userId){

        taskDao.updateStatus(Task.builder()
                            .userId(userId)
                            .status(1)
                            .build());
    }

    @Override
    public void generateTask(String userId){
        taskDao.initStatus(Task.builder()
                .userId(userId)
                .status(0)
                .build());
    }
}

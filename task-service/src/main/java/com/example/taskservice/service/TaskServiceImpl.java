package com.example.taskservice.service;

import com.example.taskservice.dao.TaskDao;
import com.example.taskservice.domin.dbo.Task;
import com.example.taskservice.domin.enums.TaskTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
                            .type(TaskTypeEnum.MODIFY_PW.getTypeName())
                            .status(1)
                            .build());
    }

    @Override
    public void generateTask(String userId){
        taskDao.initStatus(Task.builder()
                .userId(userId)
                .type(TaskTypeEnum.MODIFY_PW.getTypeName())
                .status(0)
                .build());
        log.info("generate new record");
    }

    @Override
    public Integer getTask(String userId){

        Task task = taskDao.getTask(Task.builder().userId(userId).build());
        if(task.getStatus() == 0){
            return 0;
        }
        return 1;
    }
}

package com.example.staffservice.service.impl;

import com.example.staffservice.dao.StaffDao;
import com.example.staffservice.domin.dbo.Staff;
import com.example.staffservice.service.KafkaService;
import com.example.staffservice.service.StaffService;
import com.example.staffservice.service.TaskService;
import com.example.staffservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @description:
 * @author: keyon
 * @time: 2021/12/29 5:20 下午
 */

@Service
@Slf4j
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    private UserService userService;

    private TaskService taskService;

    private KafkaService kafkaService;

    @Override
    public void addStaff(Staff staff){
        staffDao.addStaff(staff);
        try{
            userService.createUser(staff.getNumber());
        }catch (Exception e){
            kafkaService.generateUser(staff.getNumber());
        }
        try{
            taskService.generateTask(staff.getNumber());
        }catch (Exception e){
            kafkaService.generateTask(staff.getNumber());
        }
    }





    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }

    @Autowired
    public void setStaffDao(StaffDao staffDao){
        this.staffDao = staffDao;
    }

    @Autowired
    public void setKafkaService(KafkaService kafkaService){
        this.kafkaService = kafkaService;
    }
}

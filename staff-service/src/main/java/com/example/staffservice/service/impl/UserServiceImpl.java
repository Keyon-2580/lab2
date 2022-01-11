package com.example.staffservice.service.impl;

import com.example.common.domin.ResponseBean;
import com.example.staffservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/11 2:46 下午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserService userService;

    @Override
    public ResponseBean createUser(String userId) {
        userService.createUser(userId);
        log.info("task-service error, staff-service send kafka message");
        return null;
    }

    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
    }
}

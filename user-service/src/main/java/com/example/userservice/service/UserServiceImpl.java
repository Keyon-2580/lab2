package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.domin.dbo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 10:40 上午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    private TaskService taskService;

    @Autowired
    private void setUserDao(UserDao userDao){this.userDao = userDao;}

    @Autowired
    private void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }

    @Override
    public String registerUser(String userId){

        log.info("generate new record");
        String password = "";
        password = getRandomPassword();
        userDao.addUser(User.builder().userId(userId)
                        .password(password)
                        .build());

        return password;
    }

    @Override
    public Boolean userLogin(User user){
        User getUser = userDao.getUserById(user.getUserId());
        return getUser.getPassword().equals(user.getPassword());
    }

    @Override
    public void modifyPassword(User user){
        userDao.modifyPassword(user);
        taskService.updateTask(user.getUserId());
    }

    public String getRandomPassword(){
        char[] source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = 6;
        for(int i = 0;i < length; i++){
            stringBuilder.append(source[random.nextInt(source.length)]);
        }
        log.info(stringBuilder.toString());
        return stringBuilder.toString();
    }
}

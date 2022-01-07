package com.example.staffservice.service;

import com.example.staffservice.dao.StaffDao;
import com.example.staffservice.domin.dbo.Staff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

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

    @Override
    public void addStaff(Staff staff){
        staffDao.addStaff(staff);
        String password = getRandomPassword();

    }

    public String getRandomPassword(){
        char[] source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int length = 6;
        for(int i = 0;i < length; i++){
            stringBuilder.append(source[random.nextInt(source.length)]);
        }
        return stringBuilder.toString();
    }


    @Autowired
    public void setStaffDao(StaffDao staffDao){
        this.staffDao = staffDao;
    }
}

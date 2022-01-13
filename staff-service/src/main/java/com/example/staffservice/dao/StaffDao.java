package com.example.staffservice.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.staffservice.domin.dbo.Staff;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * @description:
 * @author: keyon
 * @time: 2021/12/30 2:41 下午
 */

@Repository
@CacheConfig(cacheNames = "staff")
public class StaffDao {

    private StringRedisTemplate stringRedisTemplate;

    @CachePut(key = "#staff.number")
    public Staff addStaff(Staff staff){
        return staff;
    }

    @CachePut(key = "#staff.number")
    public Staff changeDepartment(Staff staff){
        return staff;
    }


    public List<Staff> getAllStaff(){
        Set<String> keys = stringRedisTemplate.keys("*");
        List<Staff> staffs = new ArrayList<>();
        assert keys != null;
        for(String key : keys){
            String staff = stringRedisTemplate.opsForValue().get(key);
            Staff staff1 = JSONObject.parseObject(staff, Staff.class);
            staffs.add(staff1);
        }
        return staffs;

    }

    @Autowired
    private void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

}

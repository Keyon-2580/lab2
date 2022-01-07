package com.example.staffservice.dao;

import com.example.staffservice.domin.dbo.Staff;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: keyon
 * @time: 2021/12/30 2:41 下午
 */

@Repository
@CacheConfig(cacheNames = "staff")
public class StaffDao {

    @CachePut(key = "#staff.name")
    public Staff addStaff(Staff staff){

        return staff;
    }

}

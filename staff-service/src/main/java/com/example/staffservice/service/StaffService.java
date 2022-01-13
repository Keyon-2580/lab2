package com.example.staffservice.service;

import com.example.staffservice.domin.dbo.Staff;

import java.util.Map;

/**
 * @description:
 * @author: keyon
 * @time: 2021/12/29 5:32 下午
 */

public interface StaffService {

    void addStaff(Staff staff);

    void changeDepartment(Staff staff);

    Map<String, Integer> getTaskNumber();

}

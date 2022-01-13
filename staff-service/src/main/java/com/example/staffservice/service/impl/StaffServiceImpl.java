package com.example.staffservice.service.impl;

import com.example.staffservice.dao.StaffDao;
import com.example.staffservice.domin.dbo.Staff;
import com.example.staffservice.domin.enums.DepartmentEnum;
import com.example.staffservice.service.KafkaService;
import com.example.staffservice.service.StaffService;
import com.example.staffservice.service.TaskService;
import com.example.staffservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Integer> getTaskNumber(){
        Map<String, Integer> taskNumber = new HashMap<>(5);
        List<Staff> staffs= staffDao.getAllStaff();
        for(DepartmentEnum departmentEnum : DepartmentEnum.values()){
            taskNumber.put(departmentEnum.getType(), 0);
        }
        for(Staff staff : staffs){
            String department = staff.getDepartment();
            String userId = staff.getNumber();
            if(taskService.getTaskStatus(userId).getData() == 1){
                taskNumber.put(department, taskNumber.get(department) + 1);
            }
        }
        return taskNumber;
    }

    @Override
    public void changeDepartment(Staff staff){
        staffDao.changeDepartment(staff);
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

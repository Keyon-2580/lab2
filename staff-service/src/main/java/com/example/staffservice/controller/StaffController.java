package com.example.staffservice.controller;

import com.example.common.domin.ResponseBean;
import com.example.staffservice.domin.dbo.Staff;
import com.example.staffservice.service.StaffService;
import com.example.staffservice.service.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: keyon
 * @time: 2021/12/29 5:05 下午
 */

@RestController
public class StaffController {

    StaffService staffService;
    @Autowired
    public void setStaffService(StaffService staffService){
        this.staffService = staffService;
    }

    /**
     *@description:添加员工
     *@param:[staff]
     *@return:com.example.common.domin.ResponseBean
     *@time:2021/12/29 10:32 下午
     */
    @PostMapping("/register-staff")
    public ResponseBean registerStaff(@RequestBody Staff staff){

        staffService.addStaff(staff);
        return new ResponseBean<>(200,"",null);
    }


}

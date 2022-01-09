package com.example.taskservice.controller;

import com.example.common.domin.ResponseBean;
import com.example.taskservice.domin.dbo.Task;
import com.example.taskservice.service.TaskService;
import com.example.taskservice.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 3:08 下午
 */
@RestController
public class TaskController {

    TaskService taskService;
    @Autowired
    private void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("task/generate")
    public ResponseBean generateTask(@RequestParam("user_id") String userId){
        taskService.generateTask(userId);
        return new ResponseBean<>(200,"success", null);
    }

    @PutMapping("task/update")
    public ResponseBean changeStatus(@RequestParam("user_id") String userId){
        taskService.updateStatus(userId);
        return new ResponseBean<>(200, "Success", null);

    }
}

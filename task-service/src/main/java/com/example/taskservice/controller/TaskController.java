package com.example.taskservice.controller;

import com.example.common.domin.ResponseBean;
import com.example.taskservice.service.TaskService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/task/generate")
    public ResponseBean<String> generateTask(@RequestParam("user_id") String userId){
        taskService.generateTask(userId);
        return new ResponseBean<>(200,"success generate task", null);
    }

    @PutMapping("/task/update")
    public ResponseBean<String> changeStatus(@RequestParam("user_id") String userId){
        taskService.updateStatus(userId);
        return new ResponseBean<>(200, "update task", null);

    }

    @GetMapping("/task/get-task")
    public ResponseBean<Integer> getTask(@RequestParam("user_id") String userId){
        int res = taskService.getTask(userId);
        String status = "";
        if(res == 1){
            status = "done";
        }else{
            status = "todo";
        }
        return new ResponseBean<>(200, "Success get task status :" + status , res);
    }
}

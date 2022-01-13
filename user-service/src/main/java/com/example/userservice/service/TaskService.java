package com.example.userservice.service;

import com.example.common.domin.ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/10 9:49 下午
 */
@Service
@FeignClient(value = "task-service")
public interface TaskService {

    @PutMapping("/task/update")
    ResponseBean<String> updateTask(@RequestParam("user_id") String userId);

}

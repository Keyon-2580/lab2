package com.example.staffservice.service;

import com.example.common.domin.ResponseBean;
import com.example.staffservice.service.impl.TaskServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/10 9:49 下午
 */
@Service
@FeignClient(value = "task-service" , fallback = TaskServiceImpl.class)
public interface TaskService {

    @PostMapping("/task/generate")
    ResponseBean generateTask(@RequestParam("user_id") String userId);

}

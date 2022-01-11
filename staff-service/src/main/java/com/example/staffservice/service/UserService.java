package com.example.staffservice.service;

import com.example.common.domin.ResponseBean;
import com.example.staffservice.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/3 11:40 上午
 */
@FeignClient(value = "user-service", fallback = UserServiceImpl.class)
@Service
public interface UserService {

    /**
     *@description: 创建一个用户
     *@param: String userId
     *@return:void
     *@time:2022/1/3 11:42 上午
     */
    @PostMapping("/user/register")
    ResponseBean createUser(@RequestParam("user_id") String userId);
}

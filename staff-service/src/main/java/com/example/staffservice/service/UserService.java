package com.example.staffservice.service;

import com.example.common.domin.ResponseBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/3 11:40 上午
 */

public interface UserService {

    /**
     *@description: 创建一个用户
     *@param: String userId
     *@return:void
     *@time:2022/1/3 11:42 上午
     */
    @PostMapping("/create")
    ResponseBean createUser(@RequestParam("id") String userId);
}

package com.example.userservice.controller;

import com.example.common.domin.ResponseBean;
import com.example.userservice.domin.dbo.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 10:33 上午
 */
@RestController
public class UserController {
    private UserService userService;
    @Autowired
    private void setUserService(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/user/register")
    public ResponseBean<String> registerUser(@RequestParam("user_id")  String userId){


        return new ResponseBean<>(200, "register success!" , userService.registerUser(userId));
    }

    @GetMapping("/user/login")
    public ResponseBean<Boolean> userLogin(@RequestBody User user){
        if(userService.userLogin(user)){
            return new ResponseBean<>(200,"success!",null);
        }
        else{
            return new ResponseBean<>(400,"failed!",null);

        }
    }

    @PostMapping("/user/modify-password")
    public ResponseBean modifyPassword(@RequestBody User user){
        userService.modifyPW(user);
        return new ResponseBean<>(200, "success", null);
    }

}

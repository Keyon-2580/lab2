package com.example.userservice.service;

import com.example.userservice.domin.dbo.User;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 10:39 上午
 */

public interface UserService {
    /**
     *@description:
     *@param:[userId]
     *@return:java.lang.String
     *@time:2022/1/9 11:08 上午
     */
    String registerUser(String userId);

    /**
     *@description:
     *@param:[user]
     *@return:java.lang.Boolean
     *@time:2022/1/9 11:08 上午
     */
    Boolean userLogin(User user);

    /**
     *@description:
     *@param:[user]
     *@return:void
     *@time:2022/1/9 2:11 下午
     */
    void modifyPW(User user);
}

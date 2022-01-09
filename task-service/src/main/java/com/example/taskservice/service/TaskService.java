package com.example.taskservice.service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 3:14 下午
 */

public interface TaskService {
    /**
     *@description:
     *@param:[userId]
     *@return:void
     *@time:2022/1/9 3:15 下午
     */
    void updateStatus(String userId);

    /**
     *@description:
     *@param:[userId]
     *@return:void
     *@time:2022/1/9 4:17 下午
     */
    void generateTask(String userId);
}

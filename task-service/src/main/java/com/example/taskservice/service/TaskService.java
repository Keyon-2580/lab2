package com.example.taskservice.service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 3:14 下午
 */

public interface TaskService {
    /**
     *@description:更新状态
     *@param:[userId]
     *@return:void
     *@time:2022/1/9 3:15 下午
     */
    void updateStatus(String userId);

    /**
     *@description:初始化
     *@param:[userId]
     *@return:void
     *@time:2022/1/9 4:17 下午
     */
    void generateTask(String userId);

    /**
     *@description:
     *@param:[userId]
     *@return:void
     *@time:2022/1/11 11:17 上午
     */
    String getTask(String userId);
}

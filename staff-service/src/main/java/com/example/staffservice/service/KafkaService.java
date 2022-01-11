package com.example.staffservice.service;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/11 2:15 下午
 */
public interface KafkaService {

    /**
     *@description:
     *@param:[userId]
     *@return:void
     *@time:2022/1/11 2:15 下午
     */
    void generateUser(String userId);

    /**
     *@description:
     *@param:[userId]
     *@return:void
     *@time:2022/1/11 2:15 下午
     */
    void generateTask(String userId);
}

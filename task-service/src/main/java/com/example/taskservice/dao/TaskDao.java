package com.example.taskservice.dao;

import com.example.taskservice.domin.dbo.Task;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 3:18 下午
 */

@Repository
@CacheConfig(cacheNames = "task")
public class TaskDao {

    @CachePut(key = "#task.userId")
    public Task updateStatus(Task task){
        return task;
    }

    @CachePut(key = "#task.userId")
    public Task initStatus(Task task){
        return task;
    }

    @Cacheable(key = "#task.userId")
    public Task getTask(Task task){
        return task;
    }
}

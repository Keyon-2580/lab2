package com.example.userservice.dao;

import com.example.userservice.domin.dbo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 10:44 上午
 */
@Repository
@CacheConfig(cacheNames = "user")
public class UserDao {

    @CachePut(key = "#user.userId")
    public User addUser(User user){

        return user;
    }

    @Cacheable(key = "#id",unless = "#result==null")
    public User getUserById(String id) {
        return new User();
    }

    @CachePut(key = "#user.userId")
    public User modifyPassword(User user){
        return user;
    }

}

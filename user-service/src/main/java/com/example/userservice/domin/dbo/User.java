package com.example.userservice.domin.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 10:31 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String userId;

    private String password;
}

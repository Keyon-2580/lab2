package com.example.taskservice.domin.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/9 3:11 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private String userId;

    private int status;
}

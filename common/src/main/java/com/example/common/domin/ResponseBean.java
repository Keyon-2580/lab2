package com.example.common.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: keyon
 * @time: 2021/12/29 5:18 下午
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> implements Serializable {
    private int code;

    private String msg;

    private T data;
}

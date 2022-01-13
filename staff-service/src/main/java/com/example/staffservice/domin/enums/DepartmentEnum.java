package com.example.staffservice.domin.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: keyon
 * @time: 2022/1/13 1:44 下午
 */
@AllArgsConstructor
@Getter
public enum DepartmentEnum {
    //
    MATH("math"),

    ENGLISH("english"),

    CHINESE("chinese");

    private final String type;
}

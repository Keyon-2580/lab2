package com.example.staffservice.domin.dbo;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: keyon
 * @time: 2021/12/29 5:21 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {

    private String name;

    private String number;

    private String department;


}

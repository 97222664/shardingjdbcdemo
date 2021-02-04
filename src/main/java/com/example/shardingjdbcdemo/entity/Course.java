package com.example.shardingjdbcdemo.entity;

import lombok.Data;

/**
 * @author qianyucheng
 * @version 1.0
 * @date 2021/2/3 11:36
 */
@Data
public class Course {

    private Long id;
    private String name;
    private Long userId;
    private String status;

}

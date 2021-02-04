package com.example.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author qianyucheng
 * @version 1.0
 * @date 2021/2/3 14:59
 */
@Data
@TableName(value = "t_user")
public class TUser {
    private Long id;
    private String name;
    private String password;
    private Long courseId;
}
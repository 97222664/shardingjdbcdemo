package com.example.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbcdemo.entity.TUser;
import org.springframework.stereotype.Repository;

/**
 * @author qianyucheng
 * @version 1.0
 * @date 2021/2/3 11:38
 */
@Repository
public interface UserMapper extends BaseMapper<TUser> {
}

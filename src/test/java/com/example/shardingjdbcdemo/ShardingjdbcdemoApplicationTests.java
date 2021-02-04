package com.example.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingjdbcdemo.entity.Course;
import com.example.shardingjdbcdemo.entity.TUser;
import com.example.shardingjdbcdemo.mapper.CourseMapper;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private UserMapper userMapper;



    @Test
    void addUserDb() {
        log.info("========================测试垂直分库========================");
        TUser user = new TUser();

        userMapper.insert(user);
    }

    @Test
    void updateUserDb() {
        log.info("========================测试垂直分库========================");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 563750796609454081L);
        TUser user = new TUser();

        userMapper.update(user, wrapper);
    }

    @Test
    void deleteUserDb() {
        log.info("========================测试垂直分库========================");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 563750796609454081L);
        userMapper.delete(wrapper);
    }

    @Test
    void getUserDb() {
        log.info("========================测试垂直分库========================");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 563776626383388673L);
        TUser user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }


    @Test
    void addCourseDb() {
        log.info("========================测试水平分库========================");
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setUserId(100L + i);
            course.setStatus(String.valueOf(i));
            courseMapper.insert(course);
        }
    }


    @Test
    void addCourse() {
        log.info("========================测试水平分表========================");
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setUserId(100L);
            course.setStatus(String.valueOf(i));

            courseMapper.insert(course);
        }
    }

    @Test
    void getCourse() {
        log.info("========================测试水平分表========================");
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 563729630305976320L);

        Course course = courseMapper.selectOne(wrapper);

        System.out.println(course);

    }

}

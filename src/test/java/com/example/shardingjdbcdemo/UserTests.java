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
class UserTests {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private UserMapper userMapper;


    @Test
    void addUser() {
        log.info("========================测试水平分库分表========================");
        for (int i = 0; i < 10; i++) {
            TUser user = new TUser();
            user.setName("test");
            user.setPassword("123456");
            user.setCourseId((long) i);
            userMapper.insert(user);
        }
    }

    @Test
    void updateUser() {
        log.info("========================测试水平分库分表========================");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1357214325501517826L);
        TUser user = new TUser();
        user.setName("test5");
        userMapper.update(user, wrapper);
    }

    @Test
    void deleteUser() {
        log.info("========================测试水平分库分表========================");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1357214325501517826L);
        userMapper.delete(wrapper);
    }

    @Test
    void getUser() {
        log.info("========================测试水平分库分表========================");
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1357151640265097217L);
        TUser user = userMapper.selectOne(wrapper);
        log.info("====================用户信息为：" + user + "=========================");
    }




    @Test
    void addCourse() {
        log.info("========================测试垂直分库分表========================");
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setName("JAVA");
            course.setUserId(1L);
            course.setStatus("a");
            courseMapper.insert(course);
        }
    }

    @Test
    void updateCourse() {
        log.info("========================测试垂直分库分表========================");
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1357220048985890817L);
        Course course = new Course();
        course.setName("PHP");
        courseMapper.update(course, wrapper);
    }

    @Test
    void deleteCourse() {
        log.info("========================测试垂直分库分表========================");
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1357220048985890817L);
        courseMapper.delete(wrapper);
    }

    @Test
    void getCourse() {
        log.info("========================测试垂直分库分表========================");
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1357220052144201729L);
        Course course = courseMapper.selectOne(wrapper);
        log.info("====================课程信息为：" + course + "=========================");
    }
}

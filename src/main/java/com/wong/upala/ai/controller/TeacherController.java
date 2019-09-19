package com.wong.upala.ai.controller;

import com.alibaba.fastjson.JSONObject;
import com.wong.upala.ai.entity.Teacher;
import com.wong.upala.ai.service.TeacherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 教师controller类
 * @author upala
 */

@RestController
@RequestMapping("/teacher")
@Log4j2
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 获取教师信息数据
     * @param page 入参-页数
     * @param rows 入参-总记录数
     * @return 返回值
     */
    @RequestMapping(value = "/getTeacher", method = RequestMethod.GET)
    public Map<String, Object> getTeacher (@RequestParam("page")int page, @RequestParam("rows")int rows) {
        Map<String, Object> teachers = teacherService.getTeachers(page, rows);
        log.info("教师信息数据：{}", teachers);
        return teachers;
    }

    /**
     * 新增教师信息
     * @param param 入参
     * @return 返回值
     */
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public Map<String, Object> addTeacher(@RequestBody String param) {
        Teacher teacher = JSONObject.parseObject(param, Teacher.class);
        log.info("教师数据信息：{}", teacher);
        return teacherService.addTeacher(teacher);
    }

}

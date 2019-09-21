package com.wong.upala.ai.controller;

import com.alibaba.fastjson.JSONObject;
import com.wong.upala.ai.entity.Teacher;
import com.wong.upala.ai.service.TeacherService;
import com.wong.upala.ai.utils.CommUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    /**
     * 查询教师信息数据
     * @param param 入参
     * @return 返回值
     */
    @RequestMapping(value = "/queryTeacher", method = RequestMethod.POST)
    public Map<String, Object> queryTeacher(@RequestBody String param) {
        log.info("参数信息：{}", param);
        Map<String, Object> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(param);
        map.putAll(jsonObject);
        String teaNum = (String) map.get("teaNum");
        Map<String, Object> queryTeacher = teacherService.queryTeacher(teaNum);
        log.info("查询信息：{}", queryTeacher);
        return queryTeacher;
    }

    /**
     * 查询教师信息数据
     * @param param 入参
     * @return 返回值
     */
    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public Map<String, Object> updateTeacher(@RequestBody String param) {
        log.info("参数信息：{}", param);
        Teacher tea = (Teacher) CommUtils.jsonToObject(param, Teacher.class);
        Map<String, Object> resMap = teacherService.updateTeacher(tea);
        log.info("修改信息：{}", resMap);
        return resMap;
    }

    /**
     * 查询教师信息数据
     * @param param 入参
     * @return 返回值
     */
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
    public Map<String, Object> deleteTeacher(@RequestBody String param) {
        log.info("参数信息：{}", param);
        String teaNum = CommUtils.stringToObject(param);
        Map<String, Object> resMap = teacherService.deleteTeacher(teaNum);
        log.info("查询信息：{}", resMap);
        return resMap;
    }

    /**
     * 查询教师信息数据通过属性
     * @param param 入参
     * @return 返回值
     */
    @RequestMapping(value = "/queryTeaByColumn", method = RequestMethod.POST)
    public Map<String, Object> queryTeaByColumn(@RequestBody String param) {
        log.info("参数信息：{}", param);
        Map<String, Object> mapByJson = CommUtils.getMapByJson(param);
        Map<String, Object> resMap = teacherService.queryTeaByColumn(mapByJson);
        log.info("查询信息：{}", resMap);
        return resMap;
    }

}

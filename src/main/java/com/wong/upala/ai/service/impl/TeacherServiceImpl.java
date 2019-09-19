package com.wong.upala.ai.service.impl;

import com.wong.upala.ai.entity.Teacher;
import com.wong.upala.ai.mapper.TeacherMapper;
import com.wong.upala.ai.service.TeacherService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @since 2019/9/13 22:44
 *  @version 0.0.1
 *****************************/

@Service
@Log4j2
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherMapper teacherMapper;

	/**
	 * 获取教师数据
	 * @param page 入参
	 * @param rows 入参
	 * @return 返回值
	 */
	@Override
	public Map<String, Object> getTeachers(int page, int rows) {
		Map<String, Object> resultMap = new HashMap<>();
		int start = (page - 1) * rows;
		List<Teacher> teachers = teacherMapper.getTeachers(start, rows);
		Integer total = teacherMapper.getTotal();
		log.info("教师信息：{}", teachers);
		if (null != teachers && teachers.size() != 0) {
			resultMap.put("total", total);
			resultMap.put("rows", teachers);
		} else {
			resultMap.put("total", 0);
			resultMap.put("message", null);
		}
		return resultMap;
	}

	/**
	 * 新增教师
	 * @param tea 入参
	 * @return 返回值
	 */
	@Override
	public Map<String, Object> addTeacher(Teacher tea) {
		Map<String, Object> resultMap = new HashMap<>();
		// 获取当前时间
		Date createDate = new Date();
		tea.setTeaCreateDate(createDate);
		Integer integer = teacherMapper.addTeacher(tea);
		resultMap.put("status", "true");
		resultMap.put("message", "successful");
		if (integer < 0) {
			// 添加成功
			resultMap.put("status", "false");
			resultMap.put("message", "error");
		}
		return resultMap;
	}

}

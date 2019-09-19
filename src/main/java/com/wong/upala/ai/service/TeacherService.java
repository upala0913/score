package com.wong.upala.ai.service;

import com.wong.upala.ai.entity.Teacher;

import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @since 2019/9/13 22:39
 *  @version 0.0.1
 *****************************/
public interface TeacherService {

	/**
	 * 查询教师数据
	 * @param page 入参
	 * @param rows 入参
	 * @return 返回值
	 */
	Map<String, Object> getTeachers(int page, int rows);

	/**
	 * 新增教师
	 * @param tea 入参
	 * @return 返回值
	 */
	Map<String, Object> addTeacher(Teacher tea);

}

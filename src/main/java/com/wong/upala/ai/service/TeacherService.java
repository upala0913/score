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

	/**
	 * 查询教师
	 * @param teaNum 入参
	 * @return 返回值
	 */
	Map<String, Object> queryTeacher(String teaNum);

    /**
     * 修改教师数据信息
     * @param teacher 入参
     * @return 返回值
     */
    Map<String, Object> updateTeacher(Teacher teacher);

    /**
     * 删除教师信息数据
     * @param teaNum 入参
     * @return 返回值
     */
    Map<String, Object> deleteTeacher(String teaNum);

    /**
     * 查询教师通过属性
     * @param teacher 入参
     * @return 返回值
     */
    Map<String, Object> queryTeaByColumn(Map<String, Object> teacher);

}

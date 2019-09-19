package com.wong.upala.ai.service;

import com.wong.upala.ai.entity.Student;

import java.util.List;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/29 14:00
 *  @version 0.0.1
 *****************************/
public interface StudentService {

	/**
	 * 查询数据
	 * @param stuNum 入参
	 * @return 返回值
	 */
	Map<String, Student> queryStudentByNum(String stuNum);

	/**
	 * 查询学生
	 * @param page 入参
	 * @param limit 入参
	 * @return 返回值
	 */
	Map<String, Object> queryStudent(int page, int limit);

	/**
	 * 添加学生
	 * @param student 入参
	 * @return 返回值
	 */
	Map<String, Integer> addStudent(Student student);

	/**
	 * 查询通过字段
	 * @param param 入参
	 * @return 返回值
	 */
	Map<String, Object> queryByColumn(Map<String, Object> param);

	/**
	 * 删除学生信息
	 * @param stuNum 入参
	 */
	void deleteStudent(String stuNum);

	/**
	 * 修改学生信息
	 * @param student 入参
	 * @return 返回值
	 */
	Map<String, Integer> updateStudent(Student student);

}

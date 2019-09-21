package com.wong.upala.ai.mapper;

import com.wong.upala.ai.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/29 13:49
 *  @version 0.0.1
 *****************************/
public interface StudentMapper {

	/**
	 * 查询学生通过学号
	 * @param stuNum 入参
	 * @return 返回值
	 */
	Student queryStudentByNum(@Param("stuNum")String stuNum);

	/**
	 * 查询学生
	 * @param start 入参
	 * @param limit 入参
	 * @return 返回值
	 */
	List<Student> queryStudent(@Param("start")int start, @Param("limit")int limit);

	/**
	 * 获取总记录数
	 * @return 返回值
	 */
	int getTotal();

	/**
	 * 添加学生
	 * @param student 入参
	 * @return 返回值
	 */
	Integer addStudent(Student student);

	/**
	 * 查询学生通过属性
	 * @param stuNum 入参
	 * @param stuName 入参
	 * @param stuQQ 入参
	 * @param stuMobile 入参
	 * @param stuGrade 入参
	 * @param stuSubject 入参
	 * @return 返回值
	 */
	List<Student> queryByColumn(@Param("stuNum")String stuNum, @Param("stuName")String stuName,
									   @Param("stuQQ")String stuQQ,@Param("stuMobile")String stuMobile,
									   @Param("stuGrade")String stuGrade,@Param("stuSubject")String stuSubject);

	/**
	 * 删除学生信息
	 * @param stuNum 入参
	 */
	void deleteStudent(@Param("stuNum")String stuNum);

	/**
	 * 修改学生嘻嘻
	 * @param student 入参
	 * @return 返回值
	 */
	Integer updateStudent(Student student);

}

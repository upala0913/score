package com.wong.upala.ai.mapper;

import com.wong.upala.ai.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/9/13 21:47
 *  @version 0.0.1
 *****************************/
public interface TeacherMapper {

	/**
	 * 获取教师信息
	 * @param start 开始
	 * @param limit 查询数据
	 * @return 返回值
	 */
	List<Teacher> getTeachers(@Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 获取总记录数
	 * @return 返回值
	 */
	Integer getTotal();

	/**
	 * 新增教师
	 * @param tea 入参
	 * @return 返回值
	 */
	Integer addTeacher(Teacher tea);

}
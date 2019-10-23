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

	/**
	 * 查询教师数据
	 * @param teaNum 返回值
	 * @return 返回值
	 */
	Teacher queryTeacher(@Param("teaNum") String teaNum);

    /**
     * 修改教师信息
     * @param teacher 如此那
     * @return 返回值
     */
	Integer updateTeacher(Teacher teacher);

    /**
     * 删除教师信息
     * @param teaNum 入参
     */
	void deleteTeacher(@Param("teaNum") String teaNum);

	/**
	 * 通过字段查询教师信息
	 * @param teaNum 入参
	 * @param teaName 入参
	 * @param teaPhone 入参
	 * @param teaQQ 入参
	 * @param teaPosition 入参
	 * @return 返回值
	 */
	List<Teacher> queryTeaByColumn(@Param("teaNum")String teaNum, @Param("teaName")String teaName,
								   @Param("teaPhone")String teaPhone, @Param("teaQQ")String teaQQ,
								   @Param("teaPosition")String teaPosition);

	/**
	 * 获取记录数通过属性
	 * @param teaNum 入参
	 * @param teaName 入参
	 * @param teaPhone 入参
	 * @param teaQQ 入参
	 * @param teaPosition 入参
	 * @return 返回值
	 */
	Integer getTotalByColumn(@Param("teaNum")String teaNum, @Param("teaName")String teaName,
							 @Param("teaPhone")String teaPhone, @Param("teaQQ")String teaQQ,
							 @Param("teaPosition")String teaPosition);

}

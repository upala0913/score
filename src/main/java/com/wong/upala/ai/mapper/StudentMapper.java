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

	Student queryStudentByNum(@Param("stuNum")String stuNum);

	List<Student> queryStudent(@Param("start")int start, @Param("limit")int limit);

	int getTotal();

	Integer addStudent(Student student);

	List<Student> queryByColumn(@Param("stuNum")String stuNum, @Param("stuName")String stuName,
									   @Param("stuQQ")String stuQQ,@Param("stuMobile")String stuMobile,
									   @Param("stuGrade")String stuGrade,@Param("stuSubject")String stuSubject);

	void deleteStudent(@Param("stuNum")String stuNum);

	Integer updateStudent(Student student);

}

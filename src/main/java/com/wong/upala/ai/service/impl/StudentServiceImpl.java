package com.wong.upala.ai.service.impl;

import com.wong.upala.ai.entity.Student;
import com.wong.upala.ai.mapper.StudentMapper;
import com.wong.upala.ai.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/29 14:00
 *  @version 0.0.1
 *****************************/

@Service
@Log4j2
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * 查询学生
	 * @param stuNum 入参
	 * @return 返回值
	 */
	@Override
	public Map<String, Student> queryStudentByNum(String stuNum) {
		Map<String, Student> map = new HashMap<>();
		Student student = studentMapper.queryStudentByNum(stuNum);
		map.put("student", student);
		return map;
	}

	/**
	 * 查询全部的学生
	 * @param page 入参
	 * @param limit 入参
	 * @return 返回值
	 */
	@Override
	public Map<String, Object> queryStudent(int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		int start = (page - 1) * limit;
		int total = studentMapper.getTotal();
		List<Student> students = studentMapper.queryStudent(start, limit);
		map.put("total", total);
		map.put("rows", students);
		return map;
	}

	/**
	 * 增加新生
	 * @param student 入参
	 */
	@Transactional
	@Override
	public Map<String, Integer> addStudent(Student student) {
		Map<String, Integer> resultMap = new HashMap<>();
		try {
			int res = studentMapper.addStudent(student);
			log.info("返回的值：{}", res);
			if(res > 0) {
				resultMap.put("code", 1);
			} else {
				resultMap.put("code", 0);
			}
		} catch (Exception e) {
			resultMap.put("code", -1);
			log.error("添加学生失败！{}", e.getMessage());
		}
		return resultMap;
	}

	/**
	 * 查询学生信息数据
	 * @param param 入参
	 * @return 返回值
	 */
	@Override
	public Map<String, Object> queryByColumn(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
		String stuNum = (String)param.get("searchNum");
		String stuName = (String)param.get("searchName");
		String stuQQ = (String)param.get("searchQQ");
		String stuMobile = (String)param.get("searchMobile");
		String stuGrade = (String)param.get("searchGrade");
		String stuSubject = (String)param.get("searchSubject");
		List<Student> students = studentMapper.queryByColumn(stuNum, stuName, stuQQ, stuMobile, stuGrade, stuSubject);
		map.put("total", students.size());
		map.put("rows", students);
		return map;
	}

	/**
	 * 删除数据
	 * @param stuNum 入参
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteStudent(String stuNum) {
		try {
			studentMapper.deleteStudent(stuNum);
		}catch(Exception e) {
			log.error("删除失败；{}", e.getMessage());
		}
	}

	/**
	 * 修改学生信息
	 * @param student 入参
	 * @return 返回值
	 */
	@Transactional
	@Override
	public Map<String, Integer> updateStudent(Student student) {
		Map<String, Integer> resultMap = new HashMap<>();
		try {
			Integer res = studentMapper.updateStudent(student);
			log.info("获得信息：{}", res);
			if(res > 0) {
				// 修改成功
				resultMap.put("code", 1);
			}else {
				// 修改失败
				resultMap.put("code", 0);
			}
		} catch (Exception e) {
			log.error("修改学生信息失败！{}", e.getMessage());
			resultMap.put("code", -1);
		}
		return resultMap;
	}
}

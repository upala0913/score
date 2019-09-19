package com.wong.upala.ai.controller;

import com.alibaba.fastjson.JSONObject;
import com.wong.upala.ai.entity.Student;
import com.wong.upala.ai.service.StudentService;
import com.wong.upala.ai.utils.CommUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/29 14:02
 *  @version 0.0.1
 *****************************/

@Controller
@RequestMapping("/student")
@Log4j2
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * 查询信息
	 *
	 * @param param 入参
	 * @return 返回值
	 */
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Student> queryStudentByStuNum(@RequestBody String param) {
		log.info("入参的信息：{}", param);
		Student stu = CommUtils.jsonToObject(param);
		String stuNum = stu.getStuNum();
		Map<String, Student> stuMap = studentService.queryStudentByNum(stuNum);
		log.info("学生信息：{}", stuMap);
		return stuMap;
	}

	/**
	 * 获取学生信息数据
	 *
	 * @param page 入参
	 * @param rows 入参
	 * @return 返回值
	 */
	@RequestMapping(value = "/infoList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getStuInfo(int page, int rows) {
		log.info("{}, {}", page, rows);
		Map<String, Object> mapInfo = studentService.queryStudent(page, rows);
		log.info("学生信息列表：{}", mapInfo);
		return mapInfo;
	}

	/**
	 * 新增学生
	 *
	 * @param param 入参
	 * @return 返回值
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> addStudent(@RequestBody String param) {
		Student student = CommUtils.jsonToObject(param);
		Map<String, Integer> res = studentService.addStudent(student);
		log.info("添加学生返回结果信息：{}", res);
		return res;
	}

	/**
	 * 查询学生
	 *
	 * @param param 入参
	 * @return 返回值
	 */
	@RequestMapping(value = "/queryByColumn", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryByColumn(@RequestBody String param) {
		log.info(param);
		JSONObject jsonObject = JSONObject.parseObject(param);
		Map<String, Object> valueMap = new HashMap<>();
		valueMap.putAll(jsonObject);
		Map<String, Object> objectMap = studentService.queryByColumn(valueMap);
		log.info("获取数据：{}", objectMap);
		return objectMap;
	}

	/**
	 * 删除学生信息
	 *
	 * @param param 入参
	 * @return 返回值
	 */
	@RequestMapping(value = "/deleteStu", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> deleteStudent(@RequestBody String param) {
		Map<String, Integer> resultMap = new HashMap<>();
		// 删除成功
		resultMap.put("code", 1);
		log.info(param);
		Student student = CommUtils.jsonToObject(param);
		String stuNum = student.getStuNum();
		studentService.deleteStudent(stuNum);
		Map<String, Student> stuMap = studentService.queryStudentByNum(stuNum);
		Student stu = stuMap.get("student");
		if (null != stu) {
			// 删除失败
			resultMap.put("code", 0);
		}
		return resultMap;
	}

	/**
	 * 修改学生信息
	 * @param param 入参
	 * @return 返回值
	 */
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> updateStudent(@RequestBody String param) {
		Student student = CommUtils.jsonToObject(param);
		Map<String, Integer> map = studentService.updateStudent(student);
		log.info("参数信息：{}", map);
		return map;
	}

}

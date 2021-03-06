package com.wong.upala.ai.service.impl;

import com.wong.upala.ai.entity.Teacher;
import com.wong.upala.ai.mapper.TeacherMapper;
import com.wong.upala.ai.service.TeacherService;
import com.wong.upala.ai.utils.CommUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/**
	 * 查询教师
	 * @param teaNum 入参
	 * @return 返回值
	 */
	@Override
	public Map<String, Object> queryTeacher(String teaNum) {
		Map<String, Object> resultMap = new HashMap<>();
		Teacher teacher = teacherMapper.queryTeacher(teaNum);
		resultMap.put("status", "true");
		resultMap.put("message", teacher);
		if (CommUtils.isEmpty(teacher)) {
			resultMap.put("status", "false");
			resultMap.put("message", null);
		}
		return resultMap;
	}

    /**
     * 修改教师数据信息
     * @param teacher 入参
     * @return 返回值
     */
    @Override
    public Map<String, Object> updateTeacher(Teacher teacher) {
        Map<String, Object> resultMap = new HashMap<>();
        log.info("修改教师之后的数据信息：{}", teacher);
        Integer res = teacherMapper.updateTeacher(teacher);
        log.info("修改结果：{}", res);
        resultMap.put("status", "true");
        resultMap.put("message", "update success");
        if (res < 0) {
            resultMap.put("status", "false");
            resultMap.put("message", "update fail");
        }
        return resultMap;
    }

    /**
     * 删除教师信息数据
     * @param teaNum 入参
     * @return 返回值
     */
    @Override
    public Map<String, Object> deleteTeacher(String teaNum) {
        Map<String, Object> resultMap = new HashMap<>();
        log.info("参数信息：{}", teaNum);
        teacherMapper.deleteTeacher(teaNum);
        Teacher teacher = teacherMapper.queryTeacher(teaNum);
        resultMap.put("status", "true");
        resultMap.put("message", "delete success");
        if (!CommUtils.isEmpty(teacher)) {
            resultMap.put("status", "true");
            resultMap.put("message", "delete fail");
        }
        return resultMap;
    }

    /**
     * 查询教师通过属性
     * @param teacher 入参
     * @return 返回值
     */
    @Override
    public Map<String, Object> queryTeaByColumn(Map<String, Object> teacher) {
        Map<String, Object> resultMap = new HashMap<>();
        log.info("参数信息：{}", teacher);
		String teaNum = (String) teacher.get("teaNum");
		String teaName = (String) teacher.get("teaName");
		String teaPhone = (String) teacher.get("teaPhone");
		String teaQQ = (String) teacher.get("teaQQ");
		String teaPosition = (String) teacher.get("teaPosition");
		List<Teacher> teachers = teacherMapper.queryTeaByColumn(teaNum, teaName, teaPhone, teaQQ, teaPosition);
        log.info("查询数据信息：{}", teachers);
        resultMap.put("status", "true");
        resultMap.put("message", teachers);
        if (null == teachers || teachers.size() == 0) {
            resultMap.put("status", "true");
            resultMap.put("message", "query data is empty!!!");
        }
        return resultMap;
    }

}

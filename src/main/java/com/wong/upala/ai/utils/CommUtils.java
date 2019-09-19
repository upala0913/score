package com.wong.upala.ai.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wong.upala.ai.entity.Student;
import lombok.extern.log4j.Log4j2;

import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/16 1:26
 *  @version 0.0.1
 *****************************/
@Log4j2
public class CommUtils {

	/**
	 * 获取验证码
	 * @return 返回值
	 */
	public static String getKey() {
		StringBuilder sb = new StringBuilder();
		String key = "1234567890qwertyuioplkjhgfdsazxcvbnmZXCVBNMLKJHGFDSAQWERTYUIOP";
		for (int i=0;i<4;i++) {
			int ram = (int)(Math.random()*61);
			char c = key.charAt(ram);
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * JSON转String
	 * @param obj 入参
	 * @return 返回值
	 */
	public static String listToJson (Object obj) {
		return JSONArray.toJSONString(obj);
	}

	/**
	 * json转换为对象
	 * @param json 入参
	 * @return 返回值
	 */
	public static Student jsonToObject (String json) {
		Student stu = JSON.parseObject(json, Student.class);
		log.info(stu);
		return stu;
	}

}

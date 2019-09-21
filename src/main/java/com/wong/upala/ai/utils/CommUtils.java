package com.wong.upala.ai.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wong.upala.ai.entity.Student;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * json转对象
	 * @param json 入参json数据
	 * @param clazz 入参对象
	 * @return 返回值
	 */
	public static Object jsonToObject(String json, Class clazz) {
		return JSON.parseObject(json, clazz);
	}

	/**
	 * 判断对象是否为空
	 * @param obj 入参
	 * @return 若为null返回true，false
	 */
	public static boolean isEmpty(Object obj) {
		return obj == null;
	}

	/**
	 * 单个字符串的转换
	 * @param json 入参
	 * @return 返回值
	 */
	public static String stringToObject(String json) {
		Map<String, Object> map = new HashMap<>();
		JSONObject jsonObject = JSONObject.parseObject(json);
		map.putAll(jsonObject);
		return (String) map.get("teaNum");
	}

	/**
	 * 将字符串转换为map集合
	 * @param json 入参
	 * @return 返回值
	 */
	public static Map<String, Object> getMapByJson(String json) {
		Map<String, Object> map = new HashMap<>();
		JSONObject object = JSONObject.parseObject(json);
		map.putAll(object);
		return map;
	}

}

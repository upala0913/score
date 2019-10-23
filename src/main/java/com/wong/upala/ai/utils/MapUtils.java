package com.wong.upala.ai.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/17 11:56
 *  @version 0.0.1
 *****************************/

@Log4j2
public class MapUtils {

	/**
	 * 获取验证码
	 * @return 返回值
	 */
	public static Map<String, String> getMap() {
		Map<String, String> map = new HashMap<>();
		String key = CommUtils.getKey();
		map.put("key", key);
		return map;
	}

	/**
	 * 打印校验错误信息
	 * @param result 返回值
	 */
	public static Map<String, Map<String, String>> resultInfo(BindingResult result) {
		Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> info = new HashMap<>();
		info.put("message", "true");
		map.put("info", info);
		if (null != result && result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			map.put("info", getList (list));
			return map;
		}
		return map;
	}

	private static Map<String, String> getList(List<ObjectError> list) {
		Map<String, String> map = new HashMap<>();
		if (list.size() > 0) {
			FieldError error = (FieldError) list.get(0);
			map.put("message", "false");
			map.put("objectName", error.getObjectName());
			map.put("field", error.getField());
			map.put("defaultMessage", error.getDefaultMessage());
		}
		return map;
	}

}

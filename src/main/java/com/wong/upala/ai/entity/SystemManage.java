package com.wong.upala.ai.entity;

import lombok.Data;

import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/28 20:36
 *  @version 0.0.1
 *****************************/

@Data
public class SystemManage<T> {

	private int id;
	private String text;
	private List<List<T>> children;
	private String attributes;

}

package com.wong.upala.ai.entity;

import lombok.Data;

import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/28 21:33
 *  @version 0.0.1
 *****************************/

@Data
public class SystemManageOne<T> {

	private int id;
	private String text;
	private List<List<List<T>>> children;

}

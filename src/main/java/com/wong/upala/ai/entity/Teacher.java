package com.wong.upala.ai.entity;

import lombok.Data;

import java.util.Date;

/*****************************
 *  @author 王鹏
 *  @since 2019/9/13 21:31
 *  @version 0.0.1
 *****************************/

@Data
public class Teacher {

	private Integer teaId;
	private String teaName;
	private String teaNum;
	private String teaSex;
	private String teaPhone;
	/**
	 * 职位
	 */
	private String teaPosition;
	private Date teaBirthday;
	/**
	 * 入职日期
 	 */
	private Date teaInDate;
	/**
	 * 创建时间
	 */
	private Date teaCreateDate;
	private String teaQQ;

}

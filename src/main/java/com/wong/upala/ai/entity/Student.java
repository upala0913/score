package com.wong.upala.ai.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/29 13:43
 *  @version 0.0.1
 *****************************/

@Data
@ToString
public class Student {

	private Integer id;
	private String stuNum;
	private String stuName;
	private String stuSex;
	private Date stuBirthday;
	private String stuQQ;
	private String stuMobile;
	private Date stuCreateTime;
	private String stuGrade;
	private String stuSubject;

}

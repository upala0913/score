package com.wong.upala.ai.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Size;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/16 18:10
 *  @version 0.0.1
 *****************************/

@Data
@ToString
public class Admin {

	public interface Add{}

	private Integer id;
	@Size(groups={Add.class}, min = 1, max = 6)
	private String username;
	@Size(groups={Add.class}, min = 1, max = 6)
	private String userpass;

}

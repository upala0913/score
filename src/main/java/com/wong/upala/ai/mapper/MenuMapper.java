package com.wong.upala.ai.mapper;

import com.wong.upala.ai.entity.SystemManage;
import com.wong.upala.ai.entity.SystemManageOne;

import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/28 20:38
 *  @version 0.0.1
 *****************************/
public interface MenuMapper {

	SystemManageOne querySystemByType(String type);

	List<SystemManage> querySystemsByType(String type);

}

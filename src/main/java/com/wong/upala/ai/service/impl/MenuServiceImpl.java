package com.wong.upala.ai.service.impl;

import com.wong.upala.ai.entity.SystemManage;
import com.wong.upala.ai.entity.SystemManageOne;
import com.wong.upala.ai.mapper.MenuMapper;
import com.wong.upala.ai.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/28 20:45
 *  @version 0.0.1
 *****************************/

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * 获取菜单数据
	 * @return 返回值
	 */
	@Override
	public SystemManageOne querySystemByType() {

		SystemManageOne systemOne = menuMapper.querySystemByType("1");
		List<SystemManage> systemThr = menuMapper.querySystemsByType("3-1");
		SystemManageOne systemTwo = menuMapper.querySystemByType("2-1");
		List<SystemManage> systemThrTwo = menuMapper.querySystemsByType("3-2");
		SystemManageOne systemTwoTwo = menuMapper.querySystemByType("2-2");
		systemTwo.setChildren(systemThr);
		systemTwoTwo.setChildren(systemThrTwo);
		List<SystemManageOne> list = new ArrayList<>();
		list.add(systemTwo);
		list.add(systemTwoTwo);
		systemOne.setChildren(list);

		return systemOne;
	}

}

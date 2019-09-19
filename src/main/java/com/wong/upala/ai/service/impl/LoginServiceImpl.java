package com.wong.upala.ai.service.impl;

import com.wong.upala.ai.entity.Admin;
import com.wong.upala.ai.mapper.LoginMapper;
import com.wong.upala.ai.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/16 18:39
 *  @version 0.0.1
 *****************************/

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	/**
	 * 获取用户数据
	 * @param admin 入参
	 * @return 返回值
	 */
	@Override
	public Admin queryAdmin(Admin admin) {
		return loginMapper.queryAdmin(admin);
	}

}

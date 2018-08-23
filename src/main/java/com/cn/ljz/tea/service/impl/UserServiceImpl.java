package com.cn.ljz.tea.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.ljz.tea.dao.UserDao;
import com.cn.ljz.tea.entity.SysUser;
import com.cn.ljz.tea.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public SysUser findByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	
	
}

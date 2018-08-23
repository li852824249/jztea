package com.cn.ljz.tea.dao;

import com.cn.ljz.tea.entity.SysUser;

public interface UserDao {
	
	public SysUser findByUserName(String username);

}

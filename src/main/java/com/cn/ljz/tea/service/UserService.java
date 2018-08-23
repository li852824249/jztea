package com.cn.ljz.tea.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cn.ljz.tea.entity.SysUser;

public interface UserService {

	//propagation  事物传播特性   isolation事物隔离级别   timeout 事物超时   rollbackFor 事物回滚机制
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public SysUser findByUserName(String username);
}

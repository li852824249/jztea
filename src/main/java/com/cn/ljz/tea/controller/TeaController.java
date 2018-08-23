package com.cn.ljz.tea.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ljz.tea.entity.User;

@RestController
public class TeaController {

	@RequestMapping(value = "/tea/{code}", method = RequestMethod.GET)
	public User getUser(@PathVariable String code) {
		// 根据code查询
		return new User();

	}
}

package com.cn.ljz.tea.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cn.ljz.tea.entity.User;

@RestController
public class RestfulController {

	private Logger log = LoggerFactory.getLogger(RestfulController.class);

	@RequestMapping(value = "/user/{code}", method = RequestMethod.GET)
	public User getUser(@PathVariable String code) {
		// 根据code查询
		log.info("--------------code----------------" + code);
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("lidaye");
		user.setAge(28);
		if(code == "404") {
//			return "/no_found_page";
		}
		
		if(code == "500") {
//			return "/server_error_page";
		}
		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void createUser(User user) {
		// 数据库添加
	}

	@RequestMapping(value = "/user/{code}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable String code, User user) {
		// 根据code更新用户
	}

	@RequestMapping(value = "/user/{code}", method = RequestMethod.DELETE)
	public void deletUser(@PathVariable String code) {
		// 根据code删除一个用户
	}

	@RequestMapping(value="/no_found_page", method = RequestMethod.GET)
	public String catchException() {
		return "404";
	}

	@RequestMapping(value="/server_error_page",method = RequestMethod.GET)
	public String showServerError() {
		return "500";
	}

}

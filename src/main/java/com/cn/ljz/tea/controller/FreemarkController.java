package com.cn.ljz.tea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreemarkController {

	
	@RequestMapping(value="/say/{code}", method=RequestMethod.GET)
	public String sayHello(@PathVariable String code,ModelMap map) {
		map.addAttribute("name", code);
		return "hello";
	}
	
	
}

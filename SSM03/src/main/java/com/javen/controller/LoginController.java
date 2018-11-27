package com.javen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javen.model.User;
import com.javen.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(User user) {
		if(!StringUtils.isEmpty(user.getUserName())) {
			user = userService.selectByUserName(user.getUserName());
		}
		if(StringUtils.isEmpty(user)) {
			return "error";
		}else {
			return "success";
		}
	}
}

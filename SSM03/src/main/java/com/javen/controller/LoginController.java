package com.javen.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javen.model.User;
import com.javen.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/login")
public class LoginController {

	/*private static Logger log=LoggerFactory.getLogger(UserController.class);*/
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject login(User user) {
		JSONObject obj = new JSONObject();
		if(!StringUtils.isEmpty(user.getUserName())) {
			user = userService.selectByUserName(user.getUserName());
		}
		if(StringUtils.isEmpty(user)) {
			obj.put("result", "0");
			return obj;
		}else {
			obj.put("result", "1");
			return obj;
		}
	}
}

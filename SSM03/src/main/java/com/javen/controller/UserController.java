package com.javen.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javen.model.User;
import com.javen.service.UserService;
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
	
    
    @Resource
    private UserService userService;
    
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
             user = new User();  
             user.setAge(11);
             user.setId(1);
             user.setPassword("123");
             user.setUserName("javen");
        }
        model.addAttribute("user", user);  
        return "index";  
    }  
    
    @RequestMapping(value="/showUser",method=RequestMethod.GET)
    public String toIndex(HttpServletRequest request,Model model) {
    	int userId = Integer.parseInt(request.getParameter("id"));
    	User user = userService.getUserById(userId);
    	model.addAttribute("user",user);
    	return "showUser";
    }
    
    @RequestMapping(value="/showUser2",method=RequestMethod.GET)
    public String toIndex2(@RequestParam("id")String id,Model model) {
    	int userId = Integer.parseInt(id);
    	User user = userService.getUserById(userId);
    	model.addAttribute("user",user);
    	return "showUser";
    }
    
    @RequestMapping(value="/showUser3/{id}",method=RequestMethod.GET)
    public String toIndex3(@PathVariable("id")String id,Map<String,Object> model) {
    	int userId = Integer.parseInt(id);
    	User user = userService.getUserById(userId);
    	model.put("user", user);
    	return "showUser";
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public @ResponseBody User getUserInJson(@PathVariable String id,Map<String,Object> model) {
    	int userId = Integer.parseInt(id);
    	User user = userService.getUserById(userId);
    	return user;
    }
    
    @RequestMapping(value="/jsontype/{id}",method=RequestMethod.GET)
    public ResponseEntity<User> getUserInJson2(@PathVariable String id,Map<String,Object> model){
    	int userId = Integer.parseInt(id);
    	User user = userService.getUserById(userId);
    	return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    
    @RequestMapping(value="/upload")
    public String showUploadPage() {
    	return "user_admin/file";
    }
    
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException {
    	if(!file.isEmpty()) {
    	}
    	FileUtils.copyInputStreamToFile(file.getInputStream(), new File("H:\\1543284122455外协服务采购汇总.xls",System.currentTimeMillis() + file.getOriginalFilename()));
    	return "success";
    }
}




















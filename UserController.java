package com.app.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller //controller is the class level annotation To inform the compiler this class is a controller class  
@RequestMapping("/user")  //Request mapping annotations can also use with the controller annotation at the class level  To segregate one type of the request 
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
	}
	
	

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String name, @RequestParam String pass, Model map,HttpSession session, User user)
	{
		user.setName(name); user.setPass(pass);
		User us = userService.authenticateUser(name, pass);
		//System.out.println("User id : "+us.getId());
		session.setAttribute("user", us);
		map.addAttribute("user",us);
		if(us.getRole().equals("admin"))
		{
			map.addAttribute("patients", userService.getPateintList());
			return  "/user/list";
		}
		else
			return "/user/login";
		
		
		
	}
	@GetMapping("/logout")
	public String logoutUser(HttpSession session,Model map,HttpServletResponse resp,HttpServletRequest req)
	{
			User us = (User) session.getAttribute("user");
			map.addAttribute("us",us);
			session.invalidate(); 
			return "/user/login";
		
	}
	
	
	@PostMapping("/register")
	public String RegisterUser(@RequestParam String name, @RequestParam String email, @RequestParam String pass, @RequestParam String role, @RequestParam String dob, User user,SimpleDateFormat sdf) {
		System.out.println("-------------------");
		
		user.setEmail(email); user.setName(name); user.setPass(pass);user.setRole(role); user.setDob(dob);
		System.out.println(user);
		String mesg = userService.registerUser(user);
		return "/user/success";
		
	}
	
	
	@GetMapping("/register")
	public String ShowRegisterPage(Model map)
	{
		map.addAttribute("time", LocalDateTime.now());
		System.out.println("in home page method");
		return "/user/register";
	}
	@GetMapping("/login")
	public String showLoginPage() {
		return "/user/login";
	}
	
	
	
	
}

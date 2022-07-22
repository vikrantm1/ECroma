package com.app.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	public HomeController() {
		System.out.println("in ctor "+getClass());
	}
	 
	@GetMapping("/")
	public String showHomePage(Model map)
	{
		System.out.println("in home page method");
		map.addAttribute("ts", new Date());
		return "/user/login";
	}
	
}

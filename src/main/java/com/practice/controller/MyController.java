package com.practice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {
	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String about(Model model)
	{
		// http://localhost:8080/about
		System.out.println("Inside about Handler");
		model.addAttribute("name", "seema"); // sending dynamic data to html page
		model.addAttribute("date", new Date().toLocaleString());
		return "about"; // about.html
	}
	
	//handling iteration 
	@GetMapping("/example-loop")
	public String iterateHandler(Model m)
	{
		List<String> names = List.of("Ankit","Rahul","Sonam","Sarika"); // since java 9 we can use of().
		m.addAttribute("names",names);
		return "iterate";
	}
	
	@GetMapping("/condition")
	public String conditionalHandler(Model m)
	{
		m.addAttribute("isActive",true);
		m.addAttribute("gender","f");
		
		List<Integer> list = List.of(10,20);
		m.addAttribute("mylist",list);		
		return "condition";
	}
	
	// handler for including fragment 
	@GetMapping("/service")
	public String serviceHandler(Model m)
	{
		m.addAttribute("title", "This is titile from controller");
		m.addAttribute("subtitle", "This is subtitile from controller");
		m.addAttribute("date", LocalDateTime.now().toString());
		return "service";
	}
	
	//for newabout handler
	@GetMapping("/aboutnew")
	public String newAbout()
	{
		return "aboutnew";
	}
	
	//for contact handler
		@GetMapping("/contact")
		public String contact()
		{
			return "contact";
		}
}

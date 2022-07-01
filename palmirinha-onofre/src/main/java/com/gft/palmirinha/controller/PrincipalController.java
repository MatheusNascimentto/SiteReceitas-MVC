package com.gft.palmirinha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PrincipalController {
	
	 @RequestMapping("/home")
	 public String home() {
		 
		 return "home";
	 }
	 
	 @RequestMapping("/login")
	 public String login() {
		 
		 return "login";
	 }

}

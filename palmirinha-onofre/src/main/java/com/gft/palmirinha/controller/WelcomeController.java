package com.gft.palmirinha.controller;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groovyjarjarpicocli.CommandLine.Model;



@RestController
public class WelcomeController {

	
	
	@GetMapping
	public String welcome() {
		return "Bem Vindo";
	}
	

	@GetMapping("/users")
	public String users() {
		return "Authorized user";
	}
	
	@GetMapping("/managers")
	public String managers() {
		return "Authorized";
	}
	

}

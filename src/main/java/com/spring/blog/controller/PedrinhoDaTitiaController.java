package com.spring.blog.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedrinho")
public class PedrinhoDaTitiaController {
	
	@GetMapping
	public String novo() {
		return "Pedrinho da titia";
	}
	
	
	

}
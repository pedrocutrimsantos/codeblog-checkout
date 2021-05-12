package com.spring.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.spring.blog.model.Cidade;

@RestController
@RequestMapping("/LoginController")
public class LoginController {
	
	@RequestMapping("/")
    public String index(){
        return "post";
    }

	@GetMapping("/login")
	public ModelAndView cadastrar(Cidade cidade) {
		ModelAndView mv =  new ModelAndView("/login");
		
		return mv;
}
}

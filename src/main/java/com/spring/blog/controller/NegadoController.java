package com.spring.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/NegadoController")
public class NegadoController {
	
	@RequestMapping("/")
    public String index(){
        return "post";
    }
		
		@GetMapping("/negadoAdministrativo")
		public ModelAndView negadoAdministrativo() {
			ModelAndView mv =  new ModelAndView("/negadoAdministrativo");
			
			return mv;
		}
		
		@GetMapping("/negadoCliente")
		public ModelAndView negadoCliente() {
			ModelAndView mv =  new ModelAndView("/negadoCliente");
			
			return mv;
		}
		
		

	}

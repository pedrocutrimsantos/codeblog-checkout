package com.spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.repository.ProdutoRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/IndexController")
public class IndexController {


    @Autowired
	private ProdutoRepository produtoRepositorio;

	@GetMapping("/")
	@ApiOperation ("Lista Produtos Cadastrados no banco de dados e direciona para a pagina inicial")
	public ModelAndView index() {
		ModelAndView mv =  new ModelAndView("cliente/cadastrar");	
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;
	}
	
	

}



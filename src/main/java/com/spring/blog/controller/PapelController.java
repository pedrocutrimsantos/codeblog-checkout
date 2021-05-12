package com.spring.blog.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blog.model.Papel;
import com.spring.blog.repository.PapelRepository;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/PapelController")
@CrossOrigin(origins="*")
public class PapelController {
	
	@RequestMapping("/")
    public String index(){
        return "post";
    }
		
	
		@Autowired
		private PapelRepository  papelRepositorio;
		
		
		@GetMapping("/administrativo/papeis/cadastrar")
		@ApiOperation ("Cadastra os relatorio dentro do banco de dados")
		public ModelAndView cadastrar(Papel papel) {
			ModelAndView mv =  new ModelAndView("administrativo/papeis/cadastro");
			mv.addObject("papel",papel);
			return mv;
		}
		
		@GetMapping("/administrativo/papeis/listar")
		public ModelAndView listar() {
			ModelAndView mv=new ModelAndView("administrativo/papeis/lista");
			mv.addObject("listaPapeis", papelRepositorio.findAll());
			return mv;
		}
		
		@GetMapping("/administrativo/papeis/editar/{id}")
		public ModelAndView editar(@PathVariable("id") Long id) {
			Optional<Papel> papel = papelRepositorio.findById(id);
			return cadastrar(papel.get());
		}
		
		@GetMapping("/administrativo/papeis/remover/{id}")
		public ModelAndView remover(@PathVariable("id") Long id) {
			Optional<Papel> papel = papelRepositorio.findById(id);
			papelRepositorio.delete(papel.get());
			return listar();
		}
		
		@PostMapping("/administrativo/papeis/salvar")
		public ModelAndView salvar(@Valid Papel papel, BindingResult result) {
			
			if(result.hasErrors()) {
				return cadastrar(papel);
			}
			papelRepositorio.saveAndFlush(papel);
			
			return cadastrar(new Papel());
		}

	}

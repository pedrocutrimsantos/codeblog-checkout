package com.spring.blog.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.spring.blog.repository.FuncionarioRepository;
import com.spring.blog.repository.PapelRepository;
import com.spring.blog.repository.PermissaoRepository;
import com.spring.blog.model.Permissao;

@RestController
@RequestMapping("/PermissaoController")
public class PermissaoController {
	
	@RequestMapping("/")
    public String index(){
        return "post";
    }

	@Autowired
	private PermissaoRepository permissaoRepositorio;
	
	@Autowired
	private FuncionarioRepository funcionarioRepositorio;
	
	@Autowired
	private PapelRepository papelRepositorio;
	
	
	@GetMapping("/administrativo/permissoes/cadastrar")
	public ModelAndView cadastrar(Permissao permissao) {
		ModelAndView mv =  new ModelAndView("administrativo/permissoes/cadastro");
		mv.addObject("permissao",permissao);
		mv.addObject("listaFuncionarios",funcionarioRepositorio.findAll());
		mv.addObject("listaPapeis", papelRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/permissoes/listar")
	public ModelAndView listar() {
		ModelAndView mv=new ModelAndView("administrativo/permissoes/lista");
		mv.addObject("listaPermissoes", permissaoRepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/permissoes/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Permissao> permissao = permissaoRepositorio.findById(id);
		return cadastrar(permissao.get());
	}
	
	@GetMapping("/administrativo/permissoes/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Permissao> permissao = permissaoRepositorio.findById(id);
		permissaoRepositorio.delete(permissao.get());
		return listar();
	}
	
	@PostMapping("/administrativo/permissoes/salvar")
	public ModelAndView salvar(@Valid Permissao permissao, BindingResult result) {
		
		if(result.hasErrors()) {
			return cadastrar(permissao);
		}
		permissaoRepositorio.saveAndFlush(permissao);
		
		return cadastrar(new Permissao());
	}

}

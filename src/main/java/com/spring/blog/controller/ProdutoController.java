package com.spring.blog.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.spring.blog.model.Produto;
import com.spring.blog.repository.ProdutoRepository;
import com.spring.blog.service.serviceImpl.ProdutoServiceImpl;

@RestController
@RequestMapping(value ="/produto")
public class ProdutoController {


	private ProdutoServiceImpl ProdutoServiceImpl;
	@Autowired
	ProdutoRepository produtoRepository;
		

	@GetMapping("/administrativo/produtos/cadastrar")
	public ModelAndView cadastrar(Produto produto) {
		ModelAndView mv = new ModelAndView("administrativo/produtos/cadastro");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/administrativo/produtos/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/produtos/lista");
		mv.addObject("listaProdutos", produtoRepository.findAll());
		return mv;
	}

	@GetMapping("/administrativo/produtos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return cadastrar(produto.get());
	}

	@GetMapping("/administrativo/produtos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produtoRepository.delete(produto.get());
		return listar();
	}

	@GetMapping("/listarproduto")
	public ResponseEntity<List<Produto>> listarw() {
		List<Produto> produtos = ProdutoServiceImpl.findAll();
		return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
	}
	
	@PostMapping("/salvarproduto")
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		Produto c = ProdutoServiceImpl.save(produto);
		return new ResponseEntity<Produto>(c,HttpStatus.OK);
	}

}





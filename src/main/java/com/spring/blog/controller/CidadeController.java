package com.spring.blog.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring.blog.model.Cidade;
import com.spring.blog.repository.CidadeRepository;
import com.spring.blog.repository.EstadoRepository;

@RestController
@RequestMapping("/CidadeController")
public class CidadeController {

	@RequestMapping("/")
	public String index() {
		return "post";
	}

	@Autowired
	private CidadeRepository cidadeRepositorio;

	@Autowired
	private EstadoRepository estadoRepositorio;

	@RequestMapping(value = "/administrativo/cidades/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Cidade cidade) {
		ModelAndView mv = new ModelAndView("administrativo/cidades/cadastro");
		mv.addObject("cidade", cidade);
		mv.addObject("listaEstados", estadoRepositorio.findAll());
		return mv;
	}

	@GetMapping("/administrativo/cidades/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("administrativo/cidades/lista");
		mv.addObject("listaCidades", cidadeRepositorio.findAll());
		return mv;
	}

	@GetMapping("/administrativo/cidades/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Cidade> cidade = cidadeRepositorio.findById(id);
		return cadastrar(cidade.get());
	}

	@GetMapping("/administrativo/cidades/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Cidade> cidade = cidadeRepositorio.findById(id);
		cidadeRepositorio.delete(cidade.get());
		return listar();
	}

	@PostMapping("/administrativo/cidades/salvar")
	public ModelAndView salvar(@Valid Cidade cidade, BindingResult result) {

		if (result.hasErrors()) {
			return cadastrar(cidade);
		}
		cidadeRepositorio.saveAndFlush(cidade);

		return cadastrar(new Cidade());
	}

}

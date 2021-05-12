package com.spring.blog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring.blog.model.EntradaItens;
import com.spring.blog.model.EntradaProduto;
import com.spring.blog.model.Produto;
import com.spring.blog.repository.EntradaItensRepository;
import com.spring.blog.repository.EntradaProdutoRepository;
import com.spring.blog.repository.FuncionarioRepository;
import com.spring.blog.repository.ProdutoRepository;

@RestController
@RequestMapping("/EntradaProduto")
public class EntradaProdutoController {
	
	@RequestMapping("/")
    public String index(){
        return "post";
    }
	
		private List<EntradaItens> listaEntrada = new ArrayList<EntradaItens>();

		@Autowired
		private EntradaProdutoRepository entradaProdutoRepositorio;

		@Autowired
		private EntradaItensRepository entradaItensRepositorio;

		@Autowired
		private FuncionarioRepository funcionarioRepositorio;

		@Autowired
		private ProdutoRepository produtoRepositorio;

		@GetMapping("/administrativo/entrada/cadastrar")
		public ModelAndView cadastrar(EntradaProduto entrada, EntradaItens entradaItens) {
			ModelAndView mv = new ModelAndView("administrativo/entrada/cadastro");
			mv.addObject("entrada", entrada);
			mv.addObject("listaEntradaItens", this.listaEntrada);
			mv.addObject("entradaItens", entradaItens);
			mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
			mv.addObject("listaProdutos", produtoRepositorio.findAll());
			return mv;
		}

		@PostMapping("/administrativo/entrada/salvar")
		public ModelAndView salvar(String acao, EntradaProduto entrada, EntradaItens entradaItens) {

			if (acao.equals("itens")) {
				this.listaEntrada.add(entradaItens);
			} else if (acao.equals("salvar")) {
				entradaProdutoRepositorio.saveAndFlush(entrada);
				for (EntradaItens it : listaEntrada) {
					it.setEntrada(entrada);
					entradaItensRepositorio.saveAndFlush(it);
					Optional<Produto> prod = produtoRepositorio.findById(it.getProduto().getId());
					Produto produto = prod.get();
					produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + it.getQuantidade());
					produto.setValorVenda(it.getValorVenda());
					produtoRepositorio.saveAndFlush(produto);
					this.listaEntrada = new ArrayList<>();
				}
				return cadastrar(new EntradaProduto(), new EntradaItens());
			}

			return cadastrar(entrada, new EntradaItens());
		}

	}


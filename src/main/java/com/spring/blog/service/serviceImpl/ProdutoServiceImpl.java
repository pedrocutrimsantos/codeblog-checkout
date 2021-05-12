package com.spring.blog.service.serviceImpl;


import com.spring.blog.model.Cliente;
import com.spring.blog.model.Endereco;
import com.spring.blog.model.Produto;
import com.spring.blog.repository.ProdutoRepository;
import com.spring.blog.service.ProdutoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;


public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}


	private Sort sortByIdAsc() {
	return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Produto findById(long id) {
	return produtoRepository.findById(id).get();
	}

	public Produto save(Produto produto) {
		if (produto.getMarca() == null) {
			return null;
		}
		
		if (produto.getId() == null) {
			return null;
		}
	
		return produtoRepository.save(produto);
	}

}

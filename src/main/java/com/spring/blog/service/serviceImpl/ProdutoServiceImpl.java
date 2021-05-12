package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Produto;
import com.spring.blog.repository.ProdutoRepository;
import com.spring.blog.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto findById(long id) {
	return produtoRepository.findById(id).get();
	}

	@Override
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

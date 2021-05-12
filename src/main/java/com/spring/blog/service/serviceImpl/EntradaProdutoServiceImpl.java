package com.spring.blog.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.spring.blog.model.EntradaProduto;
import com.spring.blog.repository.EntradaProdutoRepository;
import com.spring.blog.service.EntradaProdutoService;

public class EntradaProdutoServiceImpl implements EntradaProdutoService{

	@Autowired
	EntradaProdutoRepository estadoRepository;

	@Override
	public List<EntradaProduto> findAll() {
		return estadoRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public EntradaProduto findById(long id) {
		return estadoRepository.findById(id).get();
	}

	@Override
	public EntradaProduto save(EntradaProduto estado) {
		return estadoRepository.save(estado);
	}

}
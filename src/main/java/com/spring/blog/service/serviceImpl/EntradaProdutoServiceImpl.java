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
		// TODO Auto-generated method stub
		return estadoRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public EntradaProduto findById(long id) {
		// TODO Auto-generated method stub
		return estadoRepository.findById(id).get();
	}

	@Override
	public EntradaProduto save(EntradaProduto estado) {
		// TODO Auto-generated method stub
		return estadoRepository.save(estado);
	}

}
package com.spring.blog.service.serviceImpl;


import com.spring.blog.model.EntradaItens;
import com.spring.blog.repository.EntradaItensRepository;
import com.spring.blog.service.EntradaItensService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class EntradaItensServiceImpl implements EntradaItensService {

	@Autowired
	EntradaItensRepository entradaItensRepository;

	@Override
	public List<EntradaItens> findAll() {
		// TODO Auto-generated method stub
		return entradaItensRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public EntradaItens findById(long id) {
		// TODO Auto-generated method stub
		return entradaItensRepository.findById(id).get();
	}

	@Override
	public EntradaItens save(EntradaItens entradaItens) {
		// TODO Auto-generated method stub
		return entradaItensRepository.save(entradaItens);
	}

}
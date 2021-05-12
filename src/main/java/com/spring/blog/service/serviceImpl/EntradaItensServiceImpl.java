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
		return entradaItensRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public EntradaItens findById(long id) {
		return entradaItensRepository.findById(id).get();
	}

	@Override
	public EntradaItens save(EntradaItens entradaItens) {
		return entradaItensRepository.save(entradaItens);
	}

}
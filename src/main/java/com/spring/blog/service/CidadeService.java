package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Cidade;

public interface CidadeService {
	List<Cidade> findAll();

	Cidade findById(long id);

	Cidade save(Cidade cidade);

}

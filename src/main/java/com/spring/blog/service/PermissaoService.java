package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Permissao;

public interface PermissaoService {
	List<Permissao> findAll();

	Permissao findById(long id);

	Permissao save(Permissao permissao);
}

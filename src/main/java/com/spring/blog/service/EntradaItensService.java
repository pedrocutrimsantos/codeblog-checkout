package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.EntradaItens;

public interface EntradaItensService {

	List<EntradaItens> findAll();

	EntradaItens findById(long id);

	EntradaItens save(EntradaItens entradaItens);
	
}

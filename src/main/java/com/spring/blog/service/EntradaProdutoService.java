package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.EntradaProduto;

public interface EntradaProdutoService {
	List<EntradaProduto> findAll();

	EntradaProduto findById(long id);

	EntradaProduto save(EntradaProduto EntradaProduto);

}

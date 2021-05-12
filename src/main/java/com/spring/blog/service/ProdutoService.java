package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.Produto;

public interface ProdutoService {

	List<Produto> findAll();

	Produto findById(long id);

	Produto save(Produto produto);
}

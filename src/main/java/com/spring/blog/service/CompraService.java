package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.Compra;

public interface CompraService {
	List<Compra> findAll();

	Compra findById(long id);

	Compra save(Compra compra);

}

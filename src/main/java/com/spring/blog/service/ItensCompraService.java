package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.ItensCompra;

public interface ItensCompraService {
	List<ItensCompra> findAll();

	ItensCompra findById(long id);

	ItensCompra save(ItensCompra itensCompra);

}

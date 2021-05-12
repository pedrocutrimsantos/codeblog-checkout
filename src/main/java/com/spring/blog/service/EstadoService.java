package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Estado;

public interface EstadoService {

	List<Estado> findAll();

	Estado findById(long id);

	Estado save(Estado estado);
}

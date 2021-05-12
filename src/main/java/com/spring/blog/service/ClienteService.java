package com.spring.blog.service;

import java.util.List;
import java.util.Optional;

import com.spring.blog.model.Cliente;

public interface ClienteService {
	List<Cliente> findAll();

	Optional<Cliente> findById(Long id);

	Cliente save(Cliente cliente);

	Cliente findByEmail(String email);
}

package com.spring.blog.service;

import java.util.List;


import com.spring.blog.model.Funcionario;

public interface FuncionarioService {

	List<Funcionario> findAll();

	Funcionario findById(long id);

	Funcionario save(Funcionario funcionario);
}

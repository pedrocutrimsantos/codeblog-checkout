package com.spring.blog.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import com.spring.blog.model.Funcionario;
import com.spring.blog.repository.FuncionarioRepository;
import com.spring.blog.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Funcionario findById(long id) {
		return funcionarioRepository.findById(id).get();
	}

	@Override
	public Funcionario save(Funcionario cliente) {
		return funcionarioRepository.save(cliente);
	}

}

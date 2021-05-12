package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Cidade;
import com.spring.blog.repository.CidadeRepository;
import com.spring.blog.service.CidadeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class CidadeServiceImpl implements CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;

	@Override
	public List<Cidade> findAll() {
		return cidadeRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Cidade findById(long id) {
		return cidadeRepository.findById(id).get();
	}

	@Override
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

}

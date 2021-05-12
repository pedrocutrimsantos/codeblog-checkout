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
		// TODO Auto-generated method stub
		return cidadeRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Cidade findById(long id) {
		// TODO Auto-generated method stub
		return cidadeRepository.findById(id).get();
	}

	@Override
	public Cidade save(Cidade cidade) {
		// TODO Auto-generated method stub
		return cidadeRepository.save(cidade);
	}

}

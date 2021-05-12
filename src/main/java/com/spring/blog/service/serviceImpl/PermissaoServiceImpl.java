package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Permissao;
import com.spring.blog.repository.PermissaoRepository;
import com.spring.blog.service.PermissaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class PermissaoServiceImpl implements PermissaoService {

	@Autowired
	PermissaoRepository permissaoRepository;
	
	@Override
	public List<Permissao> findAll() {
		// TODO Auto-generated method stub
		return permissaoRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Permissao findById(long id) {
		// TODO Auto-generated method stub
		return permissaoRepository.findById(id).get();
	}

	@Override
	public Permissao save(Permissao produto) {
		// TODO Auto-generated method stub
		return permissaoRepository.save(produto);
	}

}
package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Compra;

import com.spring.blog.repository.CompraRepository;

import com.spring.blog.service.CompraService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class CompraServiceImpl implements CompraService {

	@Autowired
	CompraRepository compraRepository;

	@Override
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return compraRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Compra findById(long id) {
		// TODO Auto-generated method stub
		return compraRepository.findById(id).get();
	}

	@Override
	public Compra save(Compra compra) {
		// TODO Auto-generated method stub
		return compraRepository.save(compra);
	}

}
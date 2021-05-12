package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Estado;
import com.spring.blog.repository.EstadoRepository;
import com.spring.blog.service.EstadoService;
import java.util.List;
import org.springframework.data.domain.Sort;


public class EstadoServiceImp implements EstadoService{

	EstadoRepository EstadoRepository;

	@Override
	public List<Estado> findAll() {
		return EstadoRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Estado findById(long id) {
		return EstadoRepository.findById(id).get();
	}

	@Override
	public Estado save(Estado estado) {
		return EstadoRepository.save(estado);
	}

}





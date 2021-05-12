package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Papel;
import com.spring.blog.repository.PapelRepository;
import com.spring.blog.service.PapelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;


public class PapelServiceImpl implements PapelService {

	@Autowired
	PapelRepository papelRepository;
	
	@Override
	public List<Papel> findAll() {
		return papelRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Papel findById(long id) {
		return papelRepository.findById(id).get();
	}

	@Override
	public Papel save(Papel papel) {
		return papelRepository.save(papel);
	}

}
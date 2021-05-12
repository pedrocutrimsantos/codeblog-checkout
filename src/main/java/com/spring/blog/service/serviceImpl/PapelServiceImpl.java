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
		// TODO Auto-generated method stub
		return papelRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public Papel findById(long id) {
		// TODO Auto-generated method stub
		return papelRepository.findById(id).get();
	}

	@Override
	public Papel save(Papel papel) {
		// TODO Auto-generated method stub
		return papelRepository.save(papel);
	}

}
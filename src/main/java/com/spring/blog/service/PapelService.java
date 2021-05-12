package com.spring.blog.service;

import java.util.List;

import com.spring.blog.model.Papel;

public interface PapelService {
	List<Papel> findAll();

	Papel findById(long id);

	Papel save(Papel papel);
}

package com.spring.blog.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.blog.model.Endereco;
import com.spring.blog.repository.EnderecoRepository;
import com.spring.blog.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
		
	@Override
	public Endereco save(Endereco endereco) {
		if (endereco.getBairro() == null || endereco.getCep().isEmpty()) {
			return null;
		}
		return enderecoRepository.save(endereco);

	}

}

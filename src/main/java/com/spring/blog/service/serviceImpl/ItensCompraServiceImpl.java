package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.ItensCompra;
import com.spring.blog.repository.ItensCompraRepository;
import com.spring.blog.service.ItensCompraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
public class ItensCompraServiceImpl implements ItensCompraService {

	@Autowired
	ItensCompraRepository itensCompraRepository;
	
	@Override
	public List<ItensCompra> findAll() {
		// TODO Auto-generated method stub
		return itensCompraRepository.findAll(sortByIdAsc());
	}

	private Sort sortByIdAsc() {
		// TODO Auto-generated method stub
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public ItensCompra findById(long id) {
		// TODO Auto-generated method stub
		return itensCompraRepository.findById(id).get();
	}

	@Override
	public ItensCompra save(ItensCompra itensCompra) {
		// TODO Auto-generated method stub
		return itensCompraRepository.save(itensCompra);
	}

}
package com.spring.blog.service.serviceImpl;


import com.spring.blog.model.ItensCompra;
import com.spring.blog.repository.ItensCompraRepository;
import com.spring.blog.service.ItensCompraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
public class ItensCompraServiceImpl implements ItensCompraService {

	

	@Autowired
	ItensCompraRepository ItensCompraCompraRepository;
	

	@Override
	public List<ItensCompra> findAll() {
		return ItensCompraCompraRepository.findAll();
	}
	private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public ItensCompra findById(long id) {
		return ItensCompraCompraRepository.findById(id).get();
	}

	@Override
	public ItensCompra save(ItensCompra itensCompra) {
		return ItensCompraCompraRepository.save(itensCompra);
	}

}
package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blog.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

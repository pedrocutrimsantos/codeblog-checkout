package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.blog.model.EntradaProduto;

public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, Long> {

}

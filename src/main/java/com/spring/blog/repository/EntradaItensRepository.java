package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.blog.model.EntradaItens;



public interface EntradaItensRepository extends JpaRepository<EntradaItens, Long> {

}

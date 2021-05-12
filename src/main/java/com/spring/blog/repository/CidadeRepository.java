package com.spring.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.blog.model.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}

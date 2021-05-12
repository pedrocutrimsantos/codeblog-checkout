package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blog.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
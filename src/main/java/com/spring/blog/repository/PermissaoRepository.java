package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blog.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}

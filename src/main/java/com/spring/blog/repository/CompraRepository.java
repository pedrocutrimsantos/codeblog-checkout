package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blog.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}

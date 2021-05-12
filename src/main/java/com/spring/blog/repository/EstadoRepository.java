package com.spring.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.blog.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}

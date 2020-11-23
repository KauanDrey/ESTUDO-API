package com.gft.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

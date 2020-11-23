package com.gft.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}

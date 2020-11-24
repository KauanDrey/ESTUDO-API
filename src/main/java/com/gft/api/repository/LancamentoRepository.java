package com.gft.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.api.model.Lancamento;
import com.gft.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}

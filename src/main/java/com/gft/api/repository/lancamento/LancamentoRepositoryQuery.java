package com.gft.api.repository.lancamento;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.gft.api.model.Lancamento;
import com.gft.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

}

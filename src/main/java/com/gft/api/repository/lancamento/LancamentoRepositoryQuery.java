package com.gft.api.repository.lancamento;

import java.util.List;

import com.gft.api.model.Lancamento;
import com.gft.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery{

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
	
	
}

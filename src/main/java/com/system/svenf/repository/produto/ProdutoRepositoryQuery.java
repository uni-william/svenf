package com.system.svenf.repository.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.system.svenf.model.Produto;
import com.system.svenf.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {

	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
}

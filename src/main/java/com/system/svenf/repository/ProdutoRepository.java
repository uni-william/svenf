package com.system.svenf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.svenf.model.Produto;
import com.system.svenf.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}

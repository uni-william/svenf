package com.system.svenf.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.system.svenf.model.Produto;
import com.system.svenf.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto atualizar(Long id, Produto produto) {
		Produto produtoSalva = buscarProdutoPeloId(id);	
		BeanUtils.copyProperties(produto, produtoSalva, "id");
		return produtoRepository.save(produtoSalva);
	}

	private Produto buscarProdutoPeloId(Long id) {
		Produto produtoSalva = this.produtoRepository.findById(id)
			      .orElseThrow(() -> new EmptyResultDataAccessException(1));
		return produtoSalva;
	}	

}

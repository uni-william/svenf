package com.system.svenf.repository.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.system.svenf.model.Produto;
import com.system.svenf.repository.filter.ProdutoFilter;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);	
		Root<Produto> root = criteriaQuery.from(Produto.class);
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteriaQuery.where(predicates);
		TypedQuery<Produto> query = manager.createQuery(criteriaQuery);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(produtoFilter));
	}


	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {		
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(produtoFilter.getDescricao()))
			predicates.add(builder.like(builder.lower(root.get("descricao")), "%" + produtoFilter.getDescricao().toLowerCase() + "%"));		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Produto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDapagina = paginaAtual * totalRegistroPorPagina;
		query.setFirstResult(primeiroRegistroDapagina);
		query.setMaxResults(totalRegistroPorPagina);
	}
	
	private Long total(ProdutoFilter produtoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Produto> root = criteriaQuery.from(Produto.class);
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteriaQuery.where(predicates);
		criteriaQuery.select(builder.count(root));
		return manager.createQuery(criteriaQuery).getSingleResult();
	}
	
}

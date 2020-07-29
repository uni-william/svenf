package com.system.svenf.repository.empresa;

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

import com.system.svenf.model.Empresa;
import com.system.svenf.repository.filter.EmpresaFilter;

public class EmpresaRepositoryImpl implements EmpresaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Empresa> filtrar(EmpresaFilter empresaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Empresa> criteriaQuery = builder.createQuery(Empresa.class);	
		Root<Empresa> root = criteriaQuery.from(Empresa.class);
		Predicate[] predicates = criarRestricoes(empresaFilter, builder, root);
		criteriaQuery.where(predicates);
		TypedQuery<Empresa> query = manager.createQuery(criteriaQuery);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(empresaFilter));
	}



	private Predicate[] criarRestricoes(EmpresaFilter empresaFilter, CriteriaBuilder builder, Root<Empresa> root) {		
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(empresaFilter.getCnpj()))
			predicates.add(builder.equal(root.get("cnpj"), empresaFilter.getCnpj()));		
		if (!StringUtils.isEmpty(empresaFilter.getRazaoSocial()))
			predicates.add(builder.like(root.get("razaoSocial"),"%" + empresaFilter.getRazaoSocial() + "%"));
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Empresa> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDapagina = paginaAtual * totalRegistroPorPagina;
		query.setFirstResult(primeiroRegistroDapagina);
		query.setMaxResults(totalRegistroPorPagina);
	}
	
	private Long total(EmpresaFilter empresaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Empresa> root = criteriaQuery.from(Empresa.class);
		Predicate[] predicates = criarRestricoes(empresaFilter, builder, root);
		criteriaQuery.where(predicates);
		criteriaQuery.select(builder.count(root));
		return manager.createQuery(criteriaQuery).getSingleResult();
	}
	
}

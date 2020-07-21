package com.system.svenf.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.system.svenf.model.Empresa;
import com.system.svenf.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public Empresa atualizar(Long id, Empresa empresa) {
		Empresa empresaSalva = buscarEmpresaPeloId(id);	
		BeanUtils.copyProperties(empresa, empresaSalva, "id");
		return empresaRepository.save(empresaSalva);
	}

	private Empresa buscarEmpresaPeloId(Long id) {
		Empresa empresaSalva = this.empresaRepository.findById(id)
			      .orElseThrow(() -> new EmptyResultDataAccessException(1));
		return empresaSalva;
	}	

}

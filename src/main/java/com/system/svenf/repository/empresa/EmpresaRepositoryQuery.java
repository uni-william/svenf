package com.system.svenf.repository.empresa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.system.svenf.model.Empresa;
import com.system.svenf.repository.filter.EmpresaFilter;

public interface EmpresaRepositoryQuery {

	public Page<Empresa> filtrar(EmpresaFilter empresaFilter, Pageable pageable);
}

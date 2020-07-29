package com.system.svenf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.svenf.model.Empresa;
import com.system.svenf.repository.empresa.EmpresaRepositoryQuery;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepositoryQuery {

}

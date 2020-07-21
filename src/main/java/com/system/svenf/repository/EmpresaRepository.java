package com.system.svenf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.svenf.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}

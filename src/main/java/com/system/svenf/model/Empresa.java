package com.system.svenf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 20, nullable = false)
	private String cnpj;

	@NotNull
	@Column(length = 120, nullable = false)
	private String razaoSocial;
	@NotNull
	@Column(length = 120, nullable = false)
	private String nomeFantasia;
	@NotNull
	@Column(length = 10, nullable = false)
	private String crt;
	@NotNull
	@Column(length = 30, nullable = false)
	private String inscricaoEstadual;

	@Embedded
	private Endereco endereco = new Endereco();

}

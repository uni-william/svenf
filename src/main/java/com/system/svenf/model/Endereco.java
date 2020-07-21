package com.system.svenf.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Embeddable
@Data
public class Endereco {

	@NotNull
	@Column(length = 120, nullable = false)
	private String logradouro;

	@Column(length = 20)
	private String numero;

	@Column(length = 50)
	private String complemento;

	@Column(length = 15)
	private String cep;

	@NotNull
	@Column(length = 80, nullable = false)
	private String nomeCidade;

	@NotNull
	@Column(length = 8, nullable = false)
	private String codigoIbegeCidade;

	@NotNull
	@Column(length = 2, nullable = false)
	private String siglaEstado;

	@NotNull
	@Column(length = 8, nullable = false)
	private String codigoIbegeEstado;

	@NotNull
	@Column(length = 50, nullable = false)
	private String pais;

	@NotNull
	@Column(length = 4, nullable = false)
	private String codigoIbegePais;

}

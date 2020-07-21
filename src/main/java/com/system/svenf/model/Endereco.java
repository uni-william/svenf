package com.system.svenf.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
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
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getCodigoIbegeCidade() {
		return codigoIbegeCidade;
	}

	public void setCodigoIbegeCidade(String codigoIbegeCidade) {
		this.codigoIbegeCidade = codigoIbegeCidade;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getCodigoIbegeEstado() {
		return codigoIbegeEstado;
	}

	public void setCodigoIbegeEstado(String codigoIbegeEstado) {
		this.codigoIbegeEstado = codigoIbegeEstado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoIbegePais() {
		return codigoIbegePais;
	}

	public void setCodigoIbegePais(String codigoIbegePais) {
		this.codigoIbegePais = codigoIbegePais;
	}
	

}

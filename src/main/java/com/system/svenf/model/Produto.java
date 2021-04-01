package com.system.svenf.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
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
@Table(name = "produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 100, nullable = false)
	private String descricao;
	
	@NotNull
	@Column(length = 30)
	private String ean;
	
	@NotNull
	@Column(length = 30)
	private String ncm;	
	
	@NotNull
	@Column(length = 30)
	private String codigoCest;	
	
	@NotNull
	@Column(length = 10)
	private String cfop;	
	
	@NotNull
	@Column(length = 4)
	private String siglaUnidMedida;	
	
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
	private  BigDecimal valorCompra;
	
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
	private  BigDecimal valorVenda;
	
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
	private  BigDecimal percentualIcms;
	
	@NotNull
	@Column(length = 4)
	private String tipoIcms;	

}

package com.cairiton.mega.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profissao")
public class Profissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotBlank
	@Size(max = 60)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "salario")
	private BigDecimal salario;

	public Profissao() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Profissao(Integer codigo, @NotBlank @Size(max = 60) String nome, @NotNull BigDecimal salario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.salario = salario;
	}

	
	

}

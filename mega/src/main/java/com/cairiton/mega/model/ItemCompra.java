package com.cairiton.mega.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "item_compra")
public class ItemCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@NotBlank
	@Size(max = 60)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "valor")
	private BigDecimal valor;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_da_compra")
	private Compra compra;

	public ItemCompra() {

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public ItemCompra(Integer codigo, @NotBlank @Size(max = 60) String nome, @NotNull BigDecimal valor,
			@NotNull Compra compra) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.compra = compra;
	}



}

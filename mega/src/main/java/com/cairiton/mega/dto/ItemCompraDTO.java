package com.cairiton.mega.dto;

import java.math.BigDecimal;


public class ItemCompraDTO {


	private Integer codigo;
	private String nome;
	private BigDecimal valor;
	private CompraDTO compra;
	
	
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
	public CompraDTO getCompra() {
		return compra;
	}
	public void setCompra(CompraDTO compra) {
		this.compra = compra;
	}

	
	
	


}

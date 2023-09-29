package com.cairiton.mega.dto;

import java.math.BigDecimal;
import java.util.List;

import com.cairiton.mega.model.ItemCompra;


public class CompraDTO{

	private Integer codigo;
	private BigDecimal valorTotal;
	private PessoaDTO pessoa;
	
	
	private List<ItemCompra> itensDaCompra;
	
	
	
	public List<ItemCompra> getItensDaCompra() {
		return itensDaCompra;
	}
	public void setItensDaCompra(List<ItemCompra> itensDaCompra) {
		this.itensDaCompra = itensDaCompra;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public PessoaDTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
	

}

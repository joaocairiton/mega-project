package com.cairiton.mega.dto;

import java.math.BigDecimal;

public class BairroDTO {

	private Integer codigo;
	private String nome;
	private BigDecimal valorDoIptu;
	
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
	public BigDecimal getValorDoIptu() {
		return valorDoIptu;
	}
	public void setValorDoIptu(BigDecimal valorDoIptu) {
		this.valorDoIptu = valorDoIptu;
	}
	
}

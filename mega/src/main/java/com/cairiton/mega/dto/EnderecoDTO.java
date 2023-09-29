package com.cairiton.mega.dto;

public class EnderecoDTO {

	private Integer codigo;
	private String rua;
	private String numero;
	private String complemento;
	private String cep;
	
	
	private BairroDTO bairro;
	
	
	/*
	 * public EnderecoDTO(Endereco endereco) {
	 * 
	 * this.codigo = endereco.getCodigo(); this.rua = endereco.getRua(); this.numero
	 * = endereco.getNumero(); this.complemento = endereco.getComplemento();
	 * this.cep = endereco.getCep(); this.bairro = new BairroDTO();
	 * this.bairro.setNome(endereco.getBairro().getNome()); }
	 */
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
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
	public BairroDTO getBairro() {
		return bairro;
	}
	public void setBairro(BairroDTO bairro) {
		this.bairro = bairro;
	}

	
}

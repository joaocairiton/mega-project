package com.cairiton.mega.dto;

import java.math.BigDecimal;
import java.util.Date;



public class PessoaDTO {
	

	private Integer codigo;
	private String nome;
	private Date dataDeNascimento;
	private String genero;
	private String portadorDeNecessidadeEspeciais;
	private BigDecimal altura;
	private BigDecimal peso;
	private String cpf;
	private String tipoDePessoa;
	private EnderecoDTO endereco;
	private ProfissaoDTO profissao;
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
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPortadorDeNecessidadeEspeciais() {
		return portadorDeNecessidadeEspeciais;
	}
	public void setPortadorDeNecessidadeEspeciais(String portadorDeNecessidadeEspeciais) {
		this.portadorDeNecessidadeEspeciais = portadorDeNecessidadeEspeciais;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoDePessoa() {
		return tipoDePessoa;
	}
	public void setTipoDePessoa(String tipoDePessoa) {
		this.tipoDePessoa = tipoDePessoa;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public ProfissaoDTO getProfissao() {
		return profissao;
	}
	public void setProfissao(ProfissaoDTO profissao) {
		this.profissao = profissao;
	}
	
	

	
}

package com.cairiton.mega.model;

import java.math.BigDecimal;
import java.util.Date;

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

import com.cairiton.mega.validation.ValidaCpf;


@Entity
@Table(name ="pessoa")
public class Pessoa {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@Column(name = "data_de_nascimento")
	private Date dataDeNascimento;
	
	@NotBlank
	@Column(name = "genero")
	private String genero;
	
	@NotBlank
	@Column(name = "Portador_de_necessidade_especiais")
	private String portadorDeNecessidadeEspeciais;
	
	@NotNull
	@Column(name = "altura")
	private BigDecimal altura;
	
	@NotNull
	@Column(name = "peso")
	private BigDecimal peso;
	
	@NotBlank
	@ValidaCpf
	@Column(name = "cpf")
	private String cpf;
	
	@NotBlank
	@Column(name = "tipo_de_pessoa")
	private String tipoDePessoa;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_do_endereco")
	private Endereco endereco;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_da_profissao")
	private Profissao profissao;
	
	public Pessoa() {
		
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public Pessoa(Integer codigo, @NotBlank String nome, @NotNull Date dataDeNascimento, @NotBlank String genero,
			@NotBlank String portadorDeNecessidadeEspeciais, @NotNull BigDecimal altura, @NotNull BigDecimal peso,
			@NotBlank String cpf, @NotBlank String tipoDePessoa, @NotNull Endereco endereco,
			@NotNull Profissao profissao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.genero = genero;
		this.portadorDeNecessidadeEspeciais = portadorDeNecessidadeEspeciais;
		this.altura = altura;
		this.peso = peso;
		this.cpf = cpf;
		this.tipoDePessoa = tipoDePessoa;
		this.endereco = endereco;
		this.profissao = profissao;
	}

	


	

}

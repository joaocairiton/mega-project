package com.cairiton.mega.model;

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

import com.cairiton.mega.validation.ValidaCep;


@Entity
@Table(name = "endereco")
public class Endereco {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank
	@Column(name= "rua")
	private String rua;
	
	@NotBlank
	@Column(name= "numero")
	private String numero;
	
	@NotBlank
	@Column(name= "complemento")
	private String complemento;
	
	@NotBlank
	@ValidaCep
	@Column(name= "cep")
	private String cep;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_do_bairro")
	private Bairro bairro;
	
	
	public Endereco() {
	}


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


	public Bairro getBairro() {
		return bairro;
	}


	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}


	public Endereco(Integer codigo, @NotBlank String rua, @NotBlank String numero, @NotBlank String complemento,
			@NotBlank String cep, @NotNull Bairro bairro) {
		super();
		this.codigo = codigo;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
	}


	
}

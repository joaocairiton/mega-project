package com.cairiton.mega.dto;

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
	
	public PessoaDTO() {
		
	}

	
}

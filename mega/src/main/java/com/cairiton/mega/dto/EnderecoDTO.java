package com.cairiton.mega.dto;

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



public class EnderecoDTO {
	
	private Integer codigo;
	private String rua;
	private String numero;
	private String complemento;
	private String cep;
	private BairroDTO bairroDTO;
	
	
	public EnderecoDTO() {
	}


	

	
}

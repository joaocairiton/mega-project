package com.cairiton.mega.dto;

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


public class ItemCompraDTO {


	private Integer codigo;
	private String nome;
	private BigDecimal valor;
	private CompraDTO compra;

	public ItemCompraDTO() {

	}
	
	


}

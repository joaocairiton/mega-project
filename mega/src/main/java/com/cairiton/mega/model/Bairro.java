package com.cairiton.mega.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cairiton.mega.validation.ValidationGroups;
import com.cairiton.mega.validation.ValidationGroups.BairroId;

@Entity
@Table(name = "bairro")
public class Bairro {

	

	
	@NotNull(groups = ValidationGroups.BairroId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank
	@Size(max = 60)
	@Column(name = "nome")
	private String nome;
	
    @NotNull
    @Column(name = "valor_do_iptu")
	private BigDecimal valorDoIptu;
	
	public Bairro() {
		
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

	public BigDecimal getValorDoIptu() {
		return valorDoIptu;
	}

	public void setValorDoIptu(BigDecimal valorDoIptu) {
		this.valorDoIptu = valorDoIptu;
	}

	public Bairro(@NotNull(groups = BairroId.class) Integer codigo, @NotBlank @Size(max = 60) String nome,
			@NotNull BigDecimal valorDoIptu) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valorDoIptu = valorDoIptu;
	}
	
}

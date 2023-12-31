package com.cairiton.mega.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "codigo_da_pessoa")
	private Pessoa pessoa;

	@OneToMany(mappedBy = "compra", fetch = FetchType.EAGER)
	private List<ItemCompra> itensDaCompra = new ArrayList<>();

	public Compra() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorTotal() {
		BigDecimal amount = new BigDecimal(0.0);
		for (ItemCompra item : this.itensDaCompra) {
			amount = amount.add(item.getValor().multiply(new BigDecimal(1)));
		}
		return amount;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ItemCompra> getItensDaCompra() {
		return itensDaCompra;
	}

	public void setItensDaCompra(List<ItemCompra> itensDaCompra) {
		this.itensDaCompra = itensDaCompra;
	}

	public Compra(Integer codigo, @NotNull BigDecimal valorTotal, Pessoa pessoa, List<ItemCompra> itensDaCompra) {
		super();
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.pessoa = pessoa;
		this.itensDaCompra = itensDaCompra;
	}

}

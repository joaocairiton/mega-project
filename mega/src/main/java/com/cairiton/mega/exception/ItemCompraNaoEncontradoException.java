package com.cairiton.mega.exception;

public class ItemCompraNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public ItemCompraNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ItemCompraNaoEncontradoException(Integer itemCompraId) {
		this(String.format("Não existe um cadastro do Item-Compra com código %d", itemCompraId));
	}

}

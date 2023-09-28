package com.cairiton.mega.exception;

public class CompraNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public CompraNaoEncontradoException(String mensagem) {
		super(mensagem);
		
	}

	public CompraNaoEncontradoException(Integer compraId) {
		this(String.format("Não existe um cadastro da Compra com código %d", compraId));
	}
}

package com.cairiton.mega.exception;

public class EnderecoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public EnderecoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	public EnderecoNaoEncontradoException(Integer enderecoId) {
		this(String.format("Não existe um cadastro do Endereco com código %d", enderecoId));
	}

}

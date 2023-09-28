package com.cairiton.mega.exception;

public class BairroNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public BairroNaoEncontradoException(String mensagem) {
		super(mensagem);
		
	}
	
	public BairroNaoEncontradoException(Integer bairroId) {
		this(String.format("Não existe um cadastro do Bairro com código %d", bairroId));
	}
	
	

}

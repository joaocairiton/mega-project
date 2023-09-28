package com.cairiton.mega.exception;

public class PessoaNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public PessoaNaoEncontradoException(String mensagem) {
		super(mensagem);
	
	}
	
	public PessoaNaoEncontradoException(Integer pessoaId) {
		this(String.format("Não existe uma cadastro da Pessoa com código %d", pessoaId));
	}

}

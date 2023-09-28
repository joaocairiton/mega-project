package com.cairiton.mega.exception;

public class ProfissaoNaoEncontradoException extends EntidadeNaoEncontradaException{


	private static final long serialVersionUID = 1L;
	
	public ProfissaoNaoEncontradoException(String mensagem) {
		super(mensagem);
		
	}
	
	public ProfissaoNaoEncontradoException(Integer profissaoId) {
		this(String.format("Não existe um cadastro de Profissao com código %d", profissaoId));
	}


}

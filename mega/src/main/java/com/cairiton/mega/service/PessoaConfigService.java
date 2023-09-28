package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.exception.PessoaNaoEncontradoException;
import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.model.Pessoa;
import com.cairiton.mega.model.Profissao;
import com.cairiton.mega.repository.PessoaRepository;

@Service
public class PessoaConfigService {

	private static final String MSG_PESSOA_EM_USO = "Pessoa de código %d não pode ser removido, pois está em uso";

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoConfigService enderecoConfigService;

	@Autowired
	private ProfissaoConfigService profissaoConfigService;

	public Pessoa buscar(Integer pessoaId) {
		return pessoaRepository.findById(pessoaId).orElseThrow(() -> new NegocioException("Pessoa não encontrado! "));
	}

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {

		Profissao profissao = profissaoConfigService.buscar(pessoa.getProfissao().getCodigo());
		Endereco endereco = enderecoConfigService.buscar(pessoa.getEndereco().getCodigo());

		pessoa.setProfissao(profissao);
		pessoa.setEndereco(endereco);

		boolean cpfEmUso = pessoaRepository.findByCpf(pessoa.getCpf()).stream()
				.anyMatch(cpfExistente -> !cpfExistente.equals(pessoa));
		if (cpfEmUso) {
			throw new NegocioException("Já existe um CPF cadastrado!");
		}

		return pessoaRepository.save(pessoa);
	}
	
	@Transactional
	public void excluir(Integer pessoaId) {
		try {
			pessoaRepository.deleteById(pessoaId);
			pessoaRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new PessoaNaoEncontradoException(pessoaId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_PESSOA_EM_USO, pessoaId));
		}

	}

	public Pessoa buscarOuFalhar(Integer pessoaId) {
		return pessoaRepository.findById(pessoaId).orElseThrow(() -> new PessoaNaoEncontradoException(pessoaId));
	}

}

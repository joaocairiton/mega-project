package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.EnderecoNaoEncontradoException;
import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Bairro;
import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.repository.EnderecoRepository;

@Service
public class EnderecoConfigService {

	private static final String MSG_ENDERECO_EM_USO = "Endereco de código %d não pode ser removido, pois está em uso";

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private BairroConfigService bairroConfigService;

	public Endereco buscar(Integer enderecoId) {
		return enderecoRepository.findById(enderecoId)
				.orElseThrow(() -> new NegocioException("Endereco não encontrado! "));
	}

	@Transactional
	public Endereco salvar(Endereco endereco) {

		Bairro bairro = bairroConfigService.buscar(endereco.getBairro().getCodigo());

		endereco.setBairro(bairro);

		return enderecoRepository.save(endereco);
	}

	@Transactional
	public void excluir(Integer enderecoId) {
		try {
			enderecoRepository.deleteById(enderecoId);
			enderecoRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new EnderecoNaoEncontradoException(enderecoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_ENDERECO_EM_USO, enderecoId));
		}
	}

	public Endereco buscarOuFalhar(Integer enderecoId) {
		return enderecoRepository.findById(enderecoId)
				.orElseThrow(() -> new EnderecoNaoEncontradoException(enderecoId));
	}

}

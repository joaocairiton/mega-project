package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.exception.ProfissaoNaoEncontradoException;
import com.cairiton.mega.model.Profissao;
import com.cairiton.mega.repository.ProfissaoRepository;

@Service
public class ProfissaoConfigService {

	private static final String MSG_PROFISSAO_EM_USO = "Profissão de código %d não pode ser removido, pois está em uso";

	@Autowired
	private ProfissaoRepository profissaoRepository;

	public Profissao buscar(Integer profissaoId) {
		return profissaoRepository.findById(profissaoId)
				.orElseThrow(() -> new NegocioException("Profissao não encontrado!"));
	}

	@Transactional
	public Profissao salvar(Profissao profissao) {

		return profissaoRepository.save(profissao);
	}

	@Transactional
	public void excluir(Integer profissaoId) {
		try {
			profissaoRepository.deleteById(profissaoId);
			profissaoRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ProfissaoNaoEncontradoException(profissaoId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_PROFISSAO_EM_USO, profissaoId));
		}

	}

	public Profissao buscarOuFalhar(Integer profissaoId) {
		return profissaoRepository.findById(profissaoId)
				.orElseThrow(() -> new ProfissaoNaoEncontradoException(profissaoId));
	}

}

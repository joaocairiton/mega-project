package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.BairroNaoEncontradoException;
import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Bairro;
import com.cairiton.mega.repository.BairroRepository;

@Service
public class BairroConfigService {

	private static final String MSG_BAIRRO_EM_USO = "Bairro de código %d não pode ser removido, pois está em uso";

	@Autowired
	private BairroRepository bairroRepository;

	public Bairro buscar(Integer bairroId) {
		return bairroRepository.findById(bairroId).orElseThrow(() -> new NegocioException("Bairro não encontrado!"));
	}

	@Transactional
	public Bairro salvar(Bairro bairro) {
		return bairroRepository.save(bairro);
	}

	@Transactional
	public void excluir(Integer bairroId) {
		try {
			bairroRepository.deleteById(bairroId);
			bairroRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new BairroNaoEncontradoException(bairroId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_BAIRRO_EM_USO, bairroId));
		}

	}

	public Bairro buscarOuFalhar(Integer bairroId) {
		return bairroRepository.findById(bairroId).orElseThrow(() -> new BairroNaoEncontradoException(bairroId));
	}

}

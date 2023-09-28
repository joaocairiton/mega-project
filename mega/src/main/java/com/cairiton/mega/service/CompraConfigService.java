package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.CompraNaoEncontradoException;
import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Compra;
import com.cairiton.mega.model.Pessoa;
import com.cairiton.mega.repository.CompraRepository;

@Service
public class CompraConfigService {

	private static final String MSG_COMPRA_EM_USO = "Compra de código %d não pode ser removido, pois está em uso";

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private PessoaConfigService pessoaConfigService;
	
	
	public Compra buscar (Integer compraId) {
		return compraRepository.findById(compraId).orElseThrow(() -> new NegocioException("Compra não encontrada!"));
	}

	@Transactional
	public Compra salvar(Compra compra) {

		Pessoa pessoa = pessoaConfigService.buscar(compra.getPessoa().getCodigo());

		compra.setPessoa(pessoa);

		return compraRepository.save(compra);
	}
	
	@Transactional
	public void excluir(Integer compraId) {
		try {
			compraRepository.deleteById(compraId);
			compraRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new CompraNaoEncontradoException(compraId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_COMPRA_EM_USO, compraId));
		}

	}
	
	public Compra buscarOuFalhar(Integer compraId) {
		return compraRepository.findById(compraId).orElseThrow(() -> new CompraNaoEncontradoException(compraId));
	}

}

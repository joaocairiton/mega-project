package com.cairiton.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.mega.exception.EntidadeEmUsoException;
import com.cairiton.mega.exception.ItemCompraNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.Compra;
import com.cairiton.mega.model.ItemCompra;
import com.cairiton.mega.repository.ItemCompraRepository;

@Service
public class ItemCompraConfigService {
	
	
	private static final String MSG_ITEM_DE_COMPRA_EM_USO = "Item da Compra de código %d não pode ser removido, pois está em uso";

	@Autowired
	private ItemCompraRepository itemCompraRepository;
	

	
	@Autowired
	private CompraConfigService compraConfigService;
	
	
	
	
	public ItemCompra buscar (Integer itemCompraId) {
		return itemCompraRepository.findById(itemCompraId).orElseThrow(() -> new NegocioException("Item-compra não encontrado! "));
	}
	
	
	@Transactional
	public ItemCompra salvar(ItemCompra itemCompra) {
		
			Compra compra = compraConfigService.buscar(itemCompra.getCompra().getCodigo());
			itemCompra.setCompra(compra);
		
		return itemCompraRepository.save(itemCompra);
	}
	
	public ItemCompra buscarOuFalhar(Integer itemCompraId) {
		return itemCompraRepository.findById(itemCompraId).orElseThrow(() -> new ItemCompraNaoEncontradoException(itemCompraId));
	}
	
	@Transactional
	public void excluir(Integer itemCompraId) {
		try {
			itemCompraRepository.deleteById(itemCompraId);
			itemCompraRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ItemCompraNaoEncontradoException(itemCompraId);

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_ITEM_DE_COMPRA_EM_USO, itemCompraId));
		}

	}

}

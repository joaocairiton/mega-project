package com.cairiton.mega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.mega.assembler.ItemDeCompraDTOAssembler;
import com.cairiton.mega.dto.ItemCompraDTO;
import com.cairiton.mega.exception.CompraNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.model.ItemCompra;
import com.cairiton.mega.repository.ItemCompraRepository;
import com.cairiton.mega.service.ItemCompraConfigService;

@RestController
@RequestMapping("/item-compras")
public class ItemCompraController {

	@Autowired
	private ItemCompraRepository itemCompraRepository;

	@Autowired
	private ItemCompraConfigService itemCompraConfigService;

	@Autowired
	private ItemDeCompraDTOAssembler itemDeCompraDTOAssembler;

	@GetMapping
	public List<ItemCompraDTO> listaDeItemCompra() {
		List<ItemCompra> listaTodoItemDeCompra = itemCompraRepository.findAll();
		return itemDeCompraDTOAssembler.toCollectionModel(listaTodoItemDeCompra);
	}

	@GetMapping("/{itemCompraId}")
	public ItemCompraDTO buscaritemCompra(@PathVariable Integer itemCompraId) {
		ItemCompra itemCompra = itemCompraConfigService.buscarOuFalhar(itemCompraId);

		return itemDeCompraDTOAssembler.toModel(itemCompra);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ItemCompraDTO adicionar(@Valid @RequestBody ItemCompra itemCompra) {
		try {
			itemCompra = itemCompraConfigService.salvar(itemCompra);
			return itemDeCompraDTOAssembler.toModel(itemCompra);

		} catch (CompraNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	

	@PutMapping("/{itemCompraId}")
	public ItemCompraDTO atualizar(@PathVariable Integer itemCompraId, @RequestBody @Valid ItemCompra itemCompra) {

		try {
			ItemCompra itemCompraAtual = itemCompraConfigService.buscarOuFalhar(itemCompraId);
			BeanUtils.copyProperties(itemCompra, itemCompraAtual, "codigo");

			itemCompraAtual = itemCompraConfigService.salvar(itemCompraAtual);
			return itemDeCompraDTOAssembler.toModel(itemCompraAtual);

		} catch (CompraNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}
	@DeleteMapping("/{itemCompraId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer itemCompraId) {
		itemCompraConfigService.excluir(itemCompraId);

	}

}

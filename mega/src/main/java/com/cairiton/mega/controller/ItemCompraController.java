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

import com.cairiton.mega.assembler.ItemCompraModelAssembler;
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
	private ItemCompraModelAssembler itemCompraModelAssembler;

	@GetMapping
	public List<ItemCompra> listaDeItemCompra() {
		return itemCompraRepository.findAll();
	}

	@GetMapping("/{itemCompraId}")
	public ItemCompra buscaritemCompra(@PathVariable Integer itemCompraId) {
		ItemCompra itemCompra = itemCompraConfigService.buscarOuFalhar(itemCompraId);

		return itemCompraModelAssembler.toModel(itemCompra);
	}

	@PostMapping
	public ItemCompra adicionar(@Valid @RequestBody ItemCompra itemCompra) {
		return itemCompraConfigService.salvar(itemCompra);
	}

	@PutMapping("/{itemCompraId}")
	public ItemCompra atualizar(@PathVariable Integer itemCompraId,	@RequestBody @Valid ItemCompra itemCompra) {
		
		ItemCompra itemCompraAtual = itemCompraConfigService.buscarOuFalhar(itemCompraId);

		BeanUtils.copyProperties(itemCompra, itemCompraAtual, "codigo");

		return itemCompraConfigService.salvar(itemCompraAtual);
	}
	
	@DeleteMapping("/{itemCompraId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer itemCompraId) {
		itemCompraConfigService.excluir(itemCompraId);

	}

}

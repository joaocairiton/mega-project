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

import com.cairiton.mega.assembler.CompraModelAssembler;
import com.cairiton.mega.model.Compra;
import com.cairiton.mega.repository.CompraRepository;
import com.cairiton.mega.service.CompraConfigService;

@RestController
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private CompraConfigService compraConfigService;

	@Autowired
	private CompraModelAssembler compraModelAssembler;

	@GetMapping
	public List<Compra> listaDeCompra() {
		return compraRepository.findAll();
	}

	@GetMapping("/{compraId}")
	public Compra buscarCompra(@PathVariable Integer compraId) {
		Compra compra = compraConfigService.buscarOuFalhar(compraId);

		return compraModelAssembler.toModel(compra);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Compra adicionar(@Valid @RequestBody Compra compra) {
		return compraConfigService.salvar(compra);
	}

	@PutMapping("/{compraId}")
	public Compra atualizar(@PathVariable Integer compraId,

			@RequestBody @Valid Compra compra) {
		Compra compraAtual = compraConfigService.buscarOuFalhar(compraId);

		BeanUtils.copyProperties(compra, compraAtual, "codigo");

		return compraConfigService.salvar(compraAtual);
	}

	@DeleteMapping("/{compraId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer compraId) {
		compraConfigService.excluir(compraId);

	}

}

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

import com.cairiton.mega.assembler.CompraDTOAssembler;
import com.cairiton.mega.dto.CompraDTO;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.exception.PessoaNaoEncontradoException;
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
	private CompraDTOAssembler compraDTOAssembler;

	@GetMapping
	public List<CompraDTO> listaDeCompra() {
		List<Compra> listarTodasCompras = compraRepository.findAll();

		return compraDTOAssembler.toCollectionModel(listarTodasCompras);
	}

	@GetMapping("/{compraId}")
	public CompraDTO buscarCompra(@PathVariable Integer compraId) {
		Compra compra = compraConfigService.buscarOuFalhar(compraId);

		return compraDTOAssembler.toModel(compra);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CompraDTO adicionar(@Valid @RequestBody Compra compra) {
		try {
			compra = compraConfigService.salvar(compra);
			return compraDTOAssembler.toModel(compra);

		} catch (PessoaNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping("/{compraId}")
	public CompraDTO atualizar(@PathVariable Integer compraId, @RequestBody @Valid Compra compra) {

		try {
			Compra compraAtual = compraConfigService.buscarOuFalhar(compraId);

			BeanUtils.copyProperties(compra, compraAtual, "codigo");

			return compraDTOAssembler.toModel(compraAtual);

		} catch (PessoaNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@DeleteMapping("/{compraId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer compraId) {
		compraConfigService.excluir(compraId);

	}

}

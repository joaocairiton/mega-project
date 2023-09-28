package com.cairiton.mega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.mega.assembler.EnderecoModelAssembler;
import com.cairiton.mega.model.Endereco;
import com.cairiton.mega.repository.EnderecoRepository;
import com.cairiton.mega.service.EnderecoConfigService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoConfigService enderecoConfigService;

	@Autowired
	private EnderecoModelAssembler enderecoModelAssembler;

	@GetMapping
	public List<Endereco> listaDeBairro() {
		return enderecoRepository.findAll();
	}

	@GetMapping("/{enderecoId}")
	public Endereco buscarEndereco(@PathVariable Integer enderecoId) {
		Endereco endereco = enderecoConfigService.buscarOuFalhar(enderecoId);

		return enderecoModelAssembler.toModel(endereco);
	}

	@PostMapping
	public Endereco adicionar(@Valid @RequestBody Endereco endereco) {
		return enderecoConfigService.salvar(endereco);
	}

	@PutMapping("/{enderecoId}")
	public Endereco atualizar(@PathVariable Integer enderecoId,

			@RequestBody @Valid Endereco endereco) {
		Endereco enderecoAtual = enderecoConfigService.buscarOuFalhar(enderecoId);

		BeanUtils.copyProperties(endereco, enderecoAtual, "codigo");

		return enderecoConfigService.salvar(enderecoAtual);
	}

	@DeleteMapping("/{enderecoId}")
	public void remover(@PathVariable Integer enderecoId) {
       enderecoConfigService.excluir(enderecoId);
	}

}

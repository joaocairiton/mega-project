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

import com.cairiton.mega.assembler.PessoaModelAssembler;
import com.cairiton.mega.model.Pessoa;
import com.cairiton.mega.repository.PessoaRepository;
import com.cairiton.mega.service.PessoaConfigService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaConfigService pessoaConfigService;

	@Autowired
	private PessoaModelAssembler pessoaModelAssembler;

	@GetMapping
	public List<Pessoa> listaDePessoa() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/{pessoaId}")
	public Pessoa buscarPessoa(@PathVariable Integer pessoaId) {
		Pessoa pessoa = pessoaConfigService.buscarOuFalhar(pessoaId);

		return pessoaModelAssembler.toModel(pessoa);
	}

	@PutMapping("/{pessoaId}")
	public Pessoa atualizar(@PathVariable Integer pessoaId, @RequestBody @Valid Pessoa pessoa) {
		
		Pessoa pessoaAtual = pessoaConfigService.buscarOuFalhar(pessoaId);

		BeanUtils.copyProperties(pessoa, pessoaAtual, "codigo");

		return pessoaConfigService.salvar(pessoaAtual);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@Valid @RequestBody Pessoa pessoa) {
		return pessoaConfigService.salvar(pessoa);
	}
	
	@DeleteMapping("/{pessoaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer pessoaId) {
		pessoaConfigService.excluir(pessoaId);

	}

}

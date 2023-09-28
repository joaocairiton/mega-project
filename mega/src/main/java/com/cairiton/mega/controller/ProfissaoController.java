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

import com.cairiton.mega.assembler.ProfissaoModelAssembler;
import com.cairiton.mega.model.Profissao;
import com.cairiton.mega.repository.ProfissaoRepository;
import com.cairiton.mega.service.ProfissaoConfigService;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {

	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Autowired
	private ProfissaoConfigService profissaoConfigService;

	@Autowired
	private ProfissaoModelAssembler profissaoModelAssembler;

	@GetMapping
	public List<Profissao> listaDeProfissao() {
		return profissaoRepository.findAll();
	}

	@GetMapping("/{profissaoId}")
	public Profissao buscarProfissao(@PathVariable Integer profissaoId) {
		Profissao profissao = profissaoConfigService.buscarOuFalhar(profissaoId);

		return profissaoModelAssembler.toModel(profissao);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Profissao adicionar(@Valid @RequestBody Profissao profissao) {
		return profissaoConfigService.salvar(profissao);
	}

	@PutMapping("/{profissaoId}")
	public Profissao atualizar(@PathVariable Integer profissaoId, @RequestBody @Valid Profissao profissao) {
		Profissao profissaoAtual = profissaoConfigService.buscarOuFalhar(profissaoId);

		BeanUtils.copyProperties(profissao, profissaoAtual, "codigo");

		return profissaoConfigService.salvar(profissaoAtual);
	}

	@DeleteMapping("/{profissaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer profissaoId) {
		profissaoConfigService.excluir(profissaoId);

	}

}

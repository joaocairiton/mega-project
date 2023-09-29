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

import com.cairiton.mega.assembler.ProfissaoDTOAssembler;
import com.cairiton.mega.dto.ProfissaoDTO;
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
	private ProfissaoDTOAssembler profissaoDTOAssembler;

	@GetMapping
	public List<ProfissaoDTO> listar() {
		List<Profissao> todosAsProfissoes = profissaoRepository.findAll();

		return profissaoDTOAssembler.toCollectionModel(todosAsProfissoes);
	}

	@GetMapping("/{profissaoId}")
	public ProfissaoDTO buscarProfissao(@PathVariable Integer profissaoId) {
		Profissao profissao = profissaoConfigService.buscarOuFalhar(profissaoId);

		return profissaoDTOAssembler.toModel(profissao);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProfissaoDTO adicionar(@Valid @RequestBody Profissao profissao) {
		profissao = profissaoConfigService.salvar(profissao);
		
		return profissaoDTOAssembler.toModel(profissao);
	}
	
	@PutMapping("/{profissaoId}")
	public ProfissaoDTO atualizar(@PathVariable Integer profissaoId, @RequestBody @Valid Profissao profissao) {
		Profissao profissaoAtual = profissaoConfigService.buscarOuFalhar(profissaoId);

		BeanUtils.copyProperties(profissao, profissaoAtual, "codigo");

		profissaoAtual =  profissaoConfigService.salvar(profissaoAtual);
		return profissaoDTOAssembler.toModel(profissaoAtual);
	}

	@DeleteMapping("/{profissaoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer profissaoId) {
		profissaoConfigService.excluir(profissaoId);

	}

}

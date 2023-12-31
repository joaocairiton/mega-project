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

import com.cairiton.mega.assembler.PessoaDTOAssembler;
import com.cairiton.mega.dto.PessoaDTO;
import com.cairiton.mega.exception.EnderecoNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;
import com.cairiton.mega.exception.ProfissaoNaoEncontradoException;
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
	private PessoaDTOAssembler pessoaDTOAssembler;

	@GetMapping
	public List<Pessoa> listaDePessoa() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/{pessoaId}")
	public PessoaDTO buscarPessoa(@PathVariable Integer pessoaId) {
		Pessoa pessoa = pessoaConfigService.buscarOuFalhar(pessoaId);

		return pessoaDTOAssembler.toModel(pessoa);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaDTO adicionar(@Valid @RequestBody Pessoa pessoa) {
		try {
			pessoa = pessoaConfigService.salvar(pessoa);
			return pessoaDTOAssembler.toModel(pessoa);

		} catch (ProfissaoNaoEncontradoException | EnderecoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping("/{pessoaId}")
	public PessoaDTO atualizar(@PathVariable Integer pessoaId, @RequestBody @Valid Pessoa pessoa) {
		try {
			Pessoa pessoaAtual = pessoaConfigService.buscarOuFalhar(pessoaId);

			BeanUtils.copyProperties(pessoa, pessoaAtual, "codigo");

			pessoaAtual = pessoaConfigService.salvar(pessoaAtual);

			return pessoaDTOAssembler.toModel(pessoaAtual);

		} catch (ProfissaoNaoEncontradoException | EnderecoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@DeleteMapping("/{pessoaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer pessoaId) {
		pessoaConfigService.excluir(pessoaId);

	}

}

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

import com.cairiton.mega.assembler.EnderecoDTOAssembler;
import com.cairiton.mega.dto.EnderecoDTO;
import com.cairiton.mega.exception.BairroNaoEncontradoException;
import com.cairiton.mega.exception.NegocioException;
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
	private EnderecoDTOAssembler enderecoDTOAssembler;

	@GetMapping
	public List<EnderecoDTO> listaDeEndereco() {
		List<Endereco> listaTodosOsEnderecos = enderecoRepository.findAll();

		return enderecoDTOAssembler.toCollectionModel(listaTodosOsEnderecos);
	}

	@GetMapping("/{enderecoId}")
	public EnderecoDTO buscar(@PathVariable Integer enderecoId) {
		Endereco endereco = enderecoConfigService.buscarOuFalhar(enderecoId);

		return enderecoDTOAssembler.toModel(endereco);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDTO adicionar(@RequestBody @Valid Endereco endereco) {
		try {
			endereco = enderecoConfigService.salvar(endereco);
			return enderecoDTOAssembler.toModel(endereco);

		} catch (BairroNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping("/{enderecoId}")
	public EnderecoDTO atualizar(@PathVariable Integer enderecoId, @RequestBody @Valid Endereco endereco) {
		try {
			Endereco enderecoAtual = enderecoConfigService.buscarOuFalhar(enderecoId);
			
			BeanUtils.copyProperties(endereco, enderecoAtual, "codigo");
			
			enderecoAtual = enderecoConfigService.salvar(enderecoAtual);
		
			return enderecoDTOAssembler.toModel(enderecoAtual);
			
		} catch (BairroNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{enderecoId}")
	public void remover(@PathVariable Integer enderecoId) {
		enderecoConfigService.excluir(enderecoId);
	}

}

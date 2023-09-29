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

import com.cairiton.mega.assembler.BairroDTOAssembler;
import com.cairiton.mega.dto.BairroDTO;
import com.cairiton.mega.model.Bairro;
import com.cairiton.mega.repository.BairroRepository;
import com.cairiton.mega.service.BairroConfigService;

@RestController
@RequestMapping("/bairros")
public class BairroController {

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private BairroConfigService bairroConfigService;

	@Autowired
	private BairroDTOAssembler bairroDTOAssembler;

	@GetMapping
	public List<BairroDTO> listar() {
		List<Bairro> todosOsBairros = bairroRepository.findAll();

		return bairroDTOAssembler.toCollectionModel(todosOsBairros);
	}

	@GetMapping("/{bairroId}")
	public BairroDTO buscarBairro(@PathVariable Integer bairroId) {
		Bairro bairro = bairroConfigService.buscarOuFalhar(bairroId);

		return bairroDTOAssembler.toModel(bairro);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BairroDTO adicionar(@RequestBody @Valid Bairro bairro) {
		bairro = bairroConfigService.salvar(bairro);
		return bairroDTOAssembler.toModel(bairro);
	}

	@PutMapping("/{bairroId}")
	public BairroDTO atualizar(@PathVariable Integer bairroId, @RequestBody @Valid Bairro bairro) {
		Bairro bairroAtual = bairroConfigService.buscarOuFalhar(bairroId);

		BeanUtils.copyProperties(bairro, bairroAtual, "codigo");

		bairroAtual = bairroConfigService.salvar(bairroAtual);
		return bairroDTOAssembler.toModel(bairroAtual);
	}

	@DeleteMapping("/{bairroId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer bairroId) {
		bairroConfigService.excluir(bairroId);

	}

}

package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.model.Pessoa;

@Component
public class PessoaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pessoa toModel(Pessoa pessoa) {
		return modelMapper.map(pessoa, Pessoa.class);
	}
	
	public List<Pessoa> toCollectionModel(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(pessoa -> toModel(pessoa))
				.collect(Collectors.toList());
	}

}

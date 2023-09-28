package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.model.Endereco;

@Component
public class EnderecoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Endereco toModel(Endereco endereco) {
		return modelMapper.map(endereco, Endereco.class);
	}
	
	public List<Endereco> toCollectionModel(List<Endereco> enderecos) {
		return enderecos.stream()
				.map(endereco -> toModel(endereco))
				.collect(Collectors.toList());
	}

}

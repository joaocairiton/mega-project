package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.dto.EnderecoDTO;
import com.cairiton.mega.model.Endereco;

@Component
public class EnderecoDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EnderecoDTO toModel(Endereco endereco) {
		return modelMapper.map(endereco, EnderecoDTO.class);
	}
	
	public List<EnderecoDTO> toCollectionModel(List<Endereco> enderecos) {
		return enderecos.stream()
				.map(endereco -> toModel(endereco))
				.collect(Collectors.toList());
	}

}

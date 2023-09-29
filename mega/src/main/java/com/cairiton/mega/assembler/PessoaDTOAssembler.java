package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.dto.PessoaDTO;
import com.cairiton.mega.model.Pessoa;

@Component
public class PessoaDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaDTO toModel(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
	
	public List<PessoaDTO> toCollectionModel(List<Pessoa> pessoas) {
		return pessoas.stream()
					  .map(pessoa -> toModel(pessoa))
				      .collect(Collectors.toList());
	}

}

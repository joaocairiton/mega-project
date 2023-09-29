package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.dto.ProfissaoDTO;
import com.cairiton.mega.model.Profissao;


@Component
public class ProfissaoDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProfissaoDTO toModel(Profissao profissao) {
		return modelMapper.map(profissao, ProfissaoDTO.class);
	}
	public List<ProfissaoDTO> toCollectionModel(List<Profissao> profissoes) {
		return profissoes.stream()
				.map(profissao -> toModel(profissao))
				.collect(Collectors.toList());
	}

}

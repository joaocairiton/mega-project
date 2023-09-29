package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.dto.BairroDTO;
import com.cairiton.mega.model.Bairro;

@Component
public class BairroDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BairroDTO toModel(Bairro bairro) {
		return modelMapper.map(bairro, BairroDTO.class);
	}
	public List<BairroDTO> toCollectionModel(List<Bairro> bairros) {
		return bairros.stream()
				.map(bairro -> toModel(bairro))
				.collect(Collectors.toList());
	}
}

package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.dto.CompraDTO;
import com.cairiton.mega.model.Compra;

@Component
public class CompraDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CompraDTO toModel(Compra compra) {
		return modelMapper.map(compra, CompraDTO.class);
	}
	
	public List<CompraDTO> toCollectionModel(List<Compra> compras) {
		return compras.stream()
				.map(compra -> toModel(compra))
				.collect(Collectors.toList());
	
	}

}

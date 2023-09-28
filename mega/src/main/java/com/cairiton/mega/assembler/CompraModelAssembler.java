package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.model.Compra;

@Component
public class CompraModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Compra toModel(Compra compra) {
		return modelMapper.map(compra, Compra.class);
	}
	
	public List<Compra> toCollectionModel(List<Compra> compras) {
		return compras.stream()
				.map(compra -> toModel(compra))
				.collect(Collectors.toList());
	}

}

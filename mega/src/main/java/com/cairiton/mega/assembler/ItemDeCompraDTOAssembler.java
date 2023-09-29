package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.dto.ItemCompraDTO;
import com.cairiton.mega.model.ItemCompra;


@Component
public class ItemDeCompraDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ItemCompraDTO toModel(ItemCompra itemDeCompra) {
		return modelMapper.map(itemDeCompra, ItemCompraDTO.class);
	}
	
	public List<ItemCompraDTO> toCollectionModel(List<ItemCompra> itensDeCompras) {
		return itensDeCompras.stream()
				.map(itemDeCompra -> toModel(itemDeCompra))
				.collect(Collectors.toList());
	
	}

}

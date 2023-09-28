package com.cairiton.mega.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairiton.mega.model.ItemCompra;


@Component
public class ItemCompraModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ItemCompra toModel(ItemCompra itemCompra) {
		return modelMapper.map(itemCompra, ItemCompra.class);
	}
	
	public List<ItemCompra> toCollectionModel(List<ItemCompra> itemCompras) {
		return itemCompras.stream()
				.map(itemCompra -> toModel(itemCompra))
				.collect(Collectors.toList());
	}

}

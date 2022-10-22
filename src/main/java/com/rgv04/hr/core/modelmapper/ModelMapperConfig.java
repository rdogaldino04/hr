package com.rgv04.hr.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    
    @Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
//		modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//		.addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);
		
		// modelMapper.createTypeMap(ItemPedidoInput.class, ItemPedido.class)
		// 	.addMappings(mapper -> mapper.skip(ItemPedido::setId));
	
		// modelMapper.createTypeMap(Endereco.class, EnderecoModel.class)
		// 	.<String>addMapping(
		// 			enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
		// 			(enderecoModelDest, value) -> enderecoModelDest.getCidade().setEstado(value)
		// 	);
	
		return modelMapper;
	}
    
}

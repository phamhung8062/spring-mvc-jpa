package springboot.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import springboot.dto.ProductDTO;
import springboot.entity.ProductEntity;


@Component
public class ProductConverter {
	public ProductDTO convertToDTO(ProductEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDTO dto=modelMapper.map(entity, ProductDTO.class);
		return dto;
	}
	public ProductEntity convertToEntity(ProductDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		ProductEntity entity=modelMapper.map(dto, ProductEntity.class);
		return entity;
	}
}

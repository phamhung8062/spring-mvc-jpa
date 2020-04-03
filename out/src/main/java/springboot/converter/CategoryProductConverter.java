package springboot.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import springboot.dto.CategoryProductDTO;
import springboot.entity.CategoryProductEntity;

@Component
public class CategoryProductConverter {
	public CategoryProductDTO convertToDTO(CategoryProductEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		CategoryProductDTO dto=modelMapper.map(entity, CategoryProductDTO.class);
		return dto;
	}
	public CategoryProductEntity convertToEntity(CategoryProductDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		CategoryProductEntity entity=modelMapper.map(dto, CategoryProductEntity.class);
		return entity;
	}
}

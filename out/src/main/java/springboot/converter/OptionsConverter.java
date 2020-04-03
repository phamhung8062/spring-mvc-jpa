package springboot.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import springboot.dto.OptionsDTO;
import springboot.entity.OptionEntity;


@Component
public class OptionsConverter {
	public OptionsDTO convertToDTO(OptionEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		OptionsDTO dto=modelMapper.map(entity, OptionsDTO.class);
		return dto;
	}
	public OptionEntity convertToEntity(OptionsDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		OptionEntity entity=modelMapper.map(dto, OptionEntity.class);
		return entity;
	}
}

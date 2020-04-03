package springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.converter.OptionsConverter;
import springboot.dto.OptionsDTO;
import springboot.entity.OptionEntity;
import springboot.repository.OptionEntityRepository;
import springboot.service.IOptionService;
@Service
public class OptionsServiceImpl implements IOptionService {
	@Autowired
	OptionsConverter optionsConverter;

	@Autowired
	OptionEntityRepository optionrepository;

	@Override
	public List<OptionsDTO> findAll() {
		List<OptionEntity> entities=optionrepository.findAll();
		return entities.stream().map(item -> optionsConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public void save(OptionsDTO dto) {
		OptionEntity  entity=optionsConverter.convertToEntity(dto);
		optionrepository.save(entity);	
	}

	@Override
	public void update(OptionsDTO dto) {
		OptionEntity entity=optionsConverter.convertToEntity(dto);
		optionrepository.save(entity);	
	}

	@Override
	public void delete(OptionsDTO dto) {
		OptionEntity entity=optionsConverter.convertToEntity(dto);
		optionrepository.delete(entity);
	}

	@Override
	public OptionsDTO findById(Long id) {
		OptionEntity entity=optionrepository.getOne(id);
		return optionsConverter.convertToDTO(entity);
	}

	
	
	
}

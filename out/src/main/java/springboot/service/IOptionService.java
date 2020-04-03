package springboot.service;

import java.util.List;

import springboot.dto.OptionsDTO;

public interface IOptionService {
	List<OptionsDTO> findAll();
	public void save(OptionsDTO dto);
	public void update(OptionsDTO dto);
	public void delete(OptionsDTO  dto);
	OptionsDTO findById(Long id);
	
}

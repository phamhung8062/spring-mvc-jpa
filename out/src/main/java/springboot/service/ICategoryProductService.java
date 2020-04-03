package springboot.service;

import java.util.List;

import springboot.dto.CategoryProductDTO;
import springboot.dto.ProductDTO;

public interface ICategoryProductService {
	List<CategoryProductDTO> findAll();
	public void save(CategoryProductDTO dto);
	public void update(CategoryProductDTO dto);
	public void delete(CategoryProductDTO  dto);
	CategoryProductDTO findById(Long id);
	
}

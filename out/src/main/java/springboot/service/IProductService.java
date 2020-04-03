package springboot.service;

import java.util.List;

import springboot.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAllCustom();
	List<ProductDTO> findAll();
	public void save(ProductDTO dto);
	public void update(ProductDTO dto);
	public void delete(ProductDTO  dto);
	ProductDTO findById(Long id);
	
}

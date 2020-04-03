package springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.converter.CategoryProductConverter;
import springboot.dto.CategoryProductDTO;
import springboot.dto.ProductDTO;
import springboot.entity.CategoryProductEntity;
import springboot.entity.ProductEntity;
import springboot.repository.ProductCategoryEntityRepository;
import springboot.service.ICategoryProductService;
@Service
public class CategoryProductServiceImpl implements ICategoryProductService {
	@Autowired
	CategoryProductConverter categoryproductconverter;

	@Autowired
	ProductCategoryEntityRepository ProductCategoryEntityRepository;

	@Override
	public List<CategoryProductDTO> findAll() {
		List<CategoryProductEntity> entities=ProductCategoryEntityRepository.findAll();
		return entities.stream().map(item -> categoryproductconverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public void save(CategoryProductDTO dto) {
		CategoryProductEntity entity=categoryproductconverter.convertToEntity(dto);
		ProductCategoryEntityRepository.save(entity);		
	}

	@Override
	public void update(CategoryProductDTO dto) {
		CategoryProductEntity entity=categoryproductconverter.convertToEntity(dto);
		ProductCategoryEntityRepository.save(entity);		
		
	}

	@Override
	public void delete(CategoryProductDTO dto) {
		CategoryProductEntity entity=categoryproductconverter.convertToEntity(dto);
		ProductCategoryEntityRepository.delete(entity);
		
	}

	@Override
	public CategoryProductDTO findById(Long id) {
		CategoryProductEntity entity=ProductCategoryEntityRepository.getOne(id);
			return categoryproductconverter.convertToDTO(entity);
	}
	
	
}

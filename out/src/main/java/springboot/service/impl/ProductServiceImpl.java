package springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.converter.ProductConverter;
import springboot.dto.ProductDTO;
import springboot.entity.CategoryProductEntity;
import springboot.entity.ProductEntity;
import springboot.repository.ProductCategoryEntityRepository;
import springboot.repository.ProductEntityRepository;
import springboot.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductEntityRepository productrepository;
	
	@Autowired
	ProductConverter productconverter;

	@Autowired
	ProductEntityRepository productRepository;
	
	@Autowired
	ProductCategoryEntityRepository ProductCategoryEntityRepository;
	
	@Override
	public List<ProductDTO> findAllCustom() {
		List<Object[]> productEntities= productrepository.findCustom();
		List<ProductDTO> productDTOs=new ArrayList<>();
		for (Object[] a : productEntities) {
			ProductDTO b= new ProductDTO();
			b.setDisplay(a[0].toString());
			b.setCpu(a[1].toString());
			
			b.setImage(a[4].toString());
			b.setCamera(a[5].toString());
			
			productDTOs.add(b);
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> entities=productRepository.findAll();
		List<ProductDTO> dtos= new ArrayList<>();
		for (ProductEntity productEntity : entities) {
			ProductDTO a=new ProductDTO();
			a=productconverter.convertToDTO(productEntity);
			a.setProductName(productEntity.getCategoryproduct().getName());
			a.setProductProducer(productEntity.getCategoryproduct().getProducer());
			a.setProductDescribe(productEntity.getCategoryproduct().getDescribe());
			dtos.add(a);
		}
		return dtos;
 	}

	@Override
	public void save(ProductDTO dto) {
		ProductEntity entity=productconverter.convertToEntity(dto);
		entity.setMemory(dto.getMemory());
		entity.setColor(dto.getColor());
		CategoryProductEntity categoryProductEntity= new CategoryProductEntity();
		categoryProductEntity.setName(dto.getProductName());
		categoryProductEntity.setDescribe(dto.getProductDescribe());
		categoryProductEntity.setProducer(dto.getProductProducer());
		ProductCategoryEntityRepository.save(categoryProductEntity);
		entity.setCategoryproduct(categoryProductEntity);
		entity=productrepository.save(entity);
	}

	@Override
	public void update(ProductDTO dto) {
		ProductEntity entity=productconverter.convertToEntity(dto);
		entity=productrepository.save(entity);
	}

	@Override
	public void delete(ProductDTO dto) {
		ProductEntity entity=productconverter.convertToEntity(dto);
		productrepository.delete(entity);
		
	}

	@Override
	public ProductDTO findById(Long id) {
        ProductEntity entity=productrepository.getOne(id);
		return productconverter.convertToDTO(entity);
	}

}

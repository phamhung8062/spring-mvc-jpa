package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.CategoryProductEntity;


public interface ProductCategoryEntityRepository  extends JpaRepository<CategoryProductEntity, Long>{

}

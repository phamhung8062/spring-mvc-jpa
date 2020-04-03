package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.ProductEntity;
import springboot.repository.custom.ProductEntityRepositoryCustom;

public interface ProductEntityRepository  extends JpaRepository<ProductEntity, Long>,ProductEntityRepositoryCustom{

}

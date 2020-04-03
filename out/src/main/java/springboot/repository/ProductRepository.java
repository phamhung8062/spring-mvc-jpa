package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
//    @Query("SELECT p from ProductEntity where p.id = :id")
//    ProductEntity find(@Param("id")long id);

    interface Product {
        String getVersionName();
        String getName();
        String getDisplay();
        String getGpu();
        String getImage();
        String getPrice();
        String getRam();
        String getColor();
        String getMemory();

    }
}

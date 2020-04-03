package springboot.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import springboot.repository.custom.ProductEntityRepositoryCustom;

@Repository
public class ProductEntityRepositoryImpl implements ProductEntityRepositoryCustom{

	@PersistenceContext
	public EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findCustom() {
		StringBuilder sql=new StringBuilder("Select product_display,product_cpu,product_price,product_ram,product_image,product_camera, ");
		sql.append(" version_name,categoryproduct.product_name,option_color,option_memory ");
		sql.append(" from product inner join version on product.version_id=version.id ");
		sql.append(" inner join categoryproduct on version.category_id=categoryproduct.id ");
		sql.append(" inner join options on product.option_id=options.id");
		Query query= entityManager.createNativeQuery(sql.toString());
		List<Object[]> authors = query.getResultList();
		
		return authors;
		
	}

	
	/*@Override
	public List<ProductEntity> findAllCustom() {
		StringBuilder sql=new StringBuilder("Select product_cpu,product_display,product_cpu,product_price,product_ram,product_image,product_camera ");
		sql.append(" version_name,categoryproduct.product_name,option_color,option_memory ");
		sql.append(" from product inner join version on product.version_id=version.id ");
		sql.append(" inner join categoryproduct on version.category_id=categoryproduct.id ");
		sql.append(" inner join options on product.option_id=options.id");
		sql.append(" Where 1=1 ");
		//StringBuilder sql=new StringBuilder("Select * from product");
		Query query= entityManager.createNativeQuery(sql.toString(),ProductEntity.class);
		return query.getResultList();
	}*/

	
}

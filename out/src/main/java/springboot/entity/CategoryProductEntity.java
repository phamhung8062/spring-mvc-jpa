package springboot.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoryproduct")
public class CategoryProductEntity extends BaseEntity {
	
	@Column(name = "categoryproduct_name")
	private String  name;
	
	@Column(name = "categoryproduct_describe")
	private String  describe;
	
	@Column(name = "categoryproduct_producer")
	private String  producer;

	@OneToMany(
	        mappedBy = "categoryproduct",
	        fetch = FetchType.LAZY
	    )
	private List<ProductEntity> Product = new ArrayList<>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public List<ProductEntity> getProduct() {
		return Product;
	}

	public void setProduct(List<ProductEntity> product) {
		Product = product;
	}
	
	
}

	

package springboot.dto;

public class CategoryProductDTO extends AbstractDTO<CategoryProductDTO> {

	
	private String productName; 
	private String productProducer;
	private String productDescribe;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductProducer() {
		return productProducer;
	}
	public void setProductProducer(String productProducer) {
		this.productProducer = productProducer;
	}
	public String getProductDescribe() {
		return productDescribe;
	}
	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	} 
	
}

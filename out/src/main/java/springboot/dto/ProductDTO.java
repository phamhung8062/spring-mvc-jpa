package springboot.dto;

public class ProductDTO extends AbstractDTO<ProductDTO> {

	private String name;
	private Integer ram;
	private String cpu;
	private String gpu; 
	private String image;
	private String display;
	private String camera;
	private Integer price;
	private String color; 
	private String memory; 
	private Integer amount; 
	private Integer status; 
	private String battery; 
	private String productName; 
	private String productProducer;
	private String productDescribe;
	
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
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

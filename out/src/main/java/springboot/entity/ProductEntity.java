package springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	@Column(name = "product_name")
	private String name;

	@Column(name = "product_ram")
	private Integer ram;

	@Column(name = "product_cpu")
	private String cpu;

	@Column(name = "product_gpu")
	private String gpu; 
	
	@Column(name = "product_image")
	private String image;

	@Column(name = "product_display")
	private String display;

	@Column(name = "product_camera")
	private String camera;

	@Column(name = "product_price")
	private Integer price;
	
	@Column(name = "product_color")
	private String color; 
	
	@Column(name = "product_amount")
	private Integer amount; 
	
	@Column(name = "product_status")
	private Integer status; 
	
	@Column(name = "product_battery")
	private String battery; 
	 
	@Column(name = "product_memory")
	private String memory;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryproduct_id")
    private CategoryProductEntity categoryproduct;
	
	public String getName() {
		return name;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
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

	
	public CategoryProductEntity getCategoryproduct() {
		return categoryproduct;
	}

	public void setCategoryproduct(CategoryProductEntity categoryproduct) {
		this.categoryproduct = categoryproduct;
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

	public Integer getProduct_price() {
		return price;
	}

	public void setProduct_price(Integer price) {
		this.price = price;
	}


	
}

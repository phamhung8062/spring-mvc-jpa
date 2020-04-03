package springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class OptionEntity extends BaseEntity {
	
	@Column(name = "option_color")
	private String  color;
	
	@Column(name = "option_memory")
	private String memory;


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	
}

	

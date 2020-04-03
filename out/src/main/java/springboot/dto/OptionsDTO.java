package springboot.dto;

public class OptionsDTO extends AbstractDTO<OptionsDTO> {

	
	private String color; 
	private String memory; 
	
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}

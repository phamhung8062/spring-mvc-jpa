package springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.CategoryProductDTO;
import springboot.service.ICategoryProductService;

@CrossOrigin
@RestController
public class CategoryProductAPI {
	@Autowired
	private ICategoryProductService categoryproductservice;
	
	
	@GetMapping(value="api/categoryproducts")
	public List<CategoryProductDTO> listProducts() {
		return  categoryproductservice.findAll();
	}
	
	@PostMapping(value="api/insert/categoryproducts",consumes={"application/json"})
	public void save(@RequestBody CategoryProductDTO dto) {
		categoryproductservice.save(dto);
	}
	
	@PutMapping(value="api/update/categoryproducts",consumes={"application/json"})
	public void update(@RequestBody CategoryProductDTO dto) {
		categoryproductservice.save(dto);
	}
	
	@DeleteMapping(value="api/delete/categoryproducts",consumes={"application/json"})
	public void delete(@RequestBody CategoryProductDTO dto) {
		categoryproductservice.delete(dto);
	}
	
	@GetMapping(value="api/categoryproductsbyid")
	public CategoryProductDTO Product(@RequestParam Long id) {
		return  categoryproductservice.findById(id);
	}


}

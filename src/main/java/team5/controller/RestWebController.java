package team5.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import team5.model.Fixset;
import team5.model.FixsetDetails;
import team5.model.Product;
import team5.model.RoleType;
import team5.model.User;
import team5.nonEntityModel.ProductNotFoundException;
import team5.nonEntityModel.UserListAJAX;
import team5.service.FixsetDetailsService;
import team5.service.FixsetService;
import team5.service.ProductService;
import team5.service.UserService;


@RestController
@CrossOrigin
public class RestWebController {
	
	@Autowired
	private UserService user_svc;
	
	@Autowired
	private ProductService prod_svc;
	
	@Autowired
	private FixsetService fixset_svc;
	
	@Autowired
	private FixsetDetailsService fixsetD_svc;
	
	//for the javascript AJAX call, listing of users
	@PostMapping("/user/users")
	public ResponseEntity<?> viewUser(@RequestBody UserListAJAX userListForm) {
		List<User> users;
		if (userListForm.getRoleType().equals("ALL")) {
			users = user_svc.findAll();
		}else {
			users = user_svc.findByJobRole(RoleType.valueOf(userListForm.getRoleType()));
		}
		return ResponseEntity.ok(users);
	}
//	-----------------------------------------------------------------------------------------------------------fixset api
//------------------------------------------------------------------------------------------------------------retrieve/read	
	//get all fixsets
	@GetMapping("/api/fixsets")
	public ResponseEntity<?> AllFixsets(){
		List<Fixset> fixsets = fixset_svc.findAll();
		return ResponseEntity.ok(fixsets);
	}
	
	//get fixset of a particular id
	@GetMapping("/api/fixsets/{id}")
	public ResponseEntity<?> findFixset(@PathVariable("id") Long id) {
		return ResponseEntity.ok(fixset_svc.findById(id));
	}

//	---------------------------------------------------------------------------------------------------------------------post/create
	//create the fixset and return the fixset
	@PostMapping("/api/fixsets")
	public ResponseEntity<?> newFixset(@RequestBody Fixset newFixset) {
		fixset_svc.save(newFixset);
		return ResponseEntity.ok(fixset_svc.findByName(newFixset.getName()));
	}
	
	//create the fixsetdetails and return the fixset
	@PostMapping("/api/fixsets/{id}/{productId}/{quantity}")
	public ResponseEntity<?> addFixsetDetail(@PathVariable("id") Long id, @PathVariable("productId") Long productId, @PathVariable("quantity") int quantity) {
		Fixset fixset = fixset_svc.findById(id);
		Product product = prod_svc.findById(productId);
		FixsetDetails x = new FixsetDetails(product, quantity);
		fixset.addFixsetDetails(x);
		fixsetD_svc.save(x);
		fixset_svc.save(fixset);
		return ResponseEntity.ok(fixset);
	}
	
//	--------------------------------------------------------------------------------------------update on fixset and fixset details
	
	//update the fixset and return the updated fixset
	@PutMapping("api/fixsets/{id}")
	public ResponseEntity<?> updateFixset(@RequestBody Fixset newFixset, @PathVariable(value = "id") Long id) {
		Optional<Fixset> sData = fixset_svc.optionalFindById(id);
		if (sData.isPresent()) {
			Fixset fixset = sData.get();
			fixset.setName(newFixset.getName());
			fixset.setDescription(newFixset.getDescription());
			fixset_svc.save(fixset);
			return new ResponseEntity<>(fixset, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//update the fixsetDetail quantity (Only can change quantity) and return the updated fixsetDetail
	@PutMapping("api/fixsets/{id}/{quantity}")
	public ResponseEntity<?> updateFixsetDetails(@PathVariable(value = "id") Long id, @PathVariable(value = "quantity") int quantity) {
		Optional<FixsetDetails> sData = fixsetD_svc.optionalFindById(id);
		if (sData.isPresent()) {
			FixsetDetails fixsetD = sData.get();
			fixsetD.setQuantity(quantity);
			fixsetD_svc.save(fixsetD);
			return new ResponseEntity<>(fixsetD, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	----------------------------------------------------------------------------------------------------------------delete
	
	//delete the fixset with all the attached fixset details as well
	@DeleteMapping("/api/fixsets/{id}")
	public ResponseEntity<?> deleteFixset(@PathVariable("id") Long id) {
		fixset_svc.deletebyId(id);
	    return ResponseEntity.ok("Deletion success");
	}	
	
	//delete the fixsetDetails only
	@DeleteMapping("/api/fixsets/{id}/{DetailsId}")
	public ResponseEntity<?> deleteFixsetDetails(@PathVariable("id") Long id, @PathVariable("DetailsId") Long DetailsId) {
		Fixset fixset = fixset_svc.findById(id);
		FixsetDetails fixsetD = fixsetD_svc.findById(DetailsId);
		fixset.removeFixsetDetails(fixsetD);
		fixset_svc.save(fixset);
		fixsetD_svc.delete(fixsetD);
		return ResponseEntity.ok("Deletion success");
	}	
	
//	-------------------------------------------------------------------------------------------------------------------products api
	
	//get all the products name with its id
	@GetMapping("/api/products")
	public ResponseEntity<?> allName(){
		List<Product> products = prod_svc.findAll();
		Map<Long, String> nameID = new HashMap<Long, String>();
		for(Product product: products) {
			nameID.put(product.getId(), product.getName());
		}
		return ResponseEntity.ok(nameID);
	}
	
	//get the product detail based on the id and attribute specified
	@GetMapping("/api/products/{id}/{attribute}")
	public ResponseEntity<?> findOne(@PathVariable("id") Long id, @PathVariable("attribute") String attribute) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = Product.class.getMethod("get"+ StringUtils.capitalize(attribute));
		Product product = prod_svc.OptionalFindById(id).orElseThrow(() -> new ProductNotFoundException(id));
		return ResponseEntity.ok(m.invoke(product).toString());
	}
	
//	//create the product and return the product id
//	@PostMapping("/api/products")
//	public ResponseEntity<?> newProduct(@RequestBody Product newProduct) {
//		prod_svc.save(newProduct);
//		return ResponseEntity.ok(prod_svc.findByName(newProduct.getName()).getId());
//	}
	
//	//update the quantity based on the product id and return the new quantity
//	@PutMapping("api/products/{id}/{quantity}")
//	public ResponseEntity<?> updateProductQuantity(@PathVariable(value = "id") Long id, @PathVariable(value="quantity") Long quantity) {
//		Product product = prod_svc.findById(id);
//		if (product.getUnit()<quantity) {
//			return ResponseEntity.badRequest()
//		            .body("Not enough stock");
//		}else {
//			prod_svc.updateStock(quantity, id);
//			Map<Long, Long> stock = new HashMap<Long, Long>();
//			stock.put(product.getId(), product.getUnit()- quantity);
//			return ResponseEntity.ok(stock);
//		}
//	}
	
//	//delete the product
//	@DeleteMapping("/api/products/{id}")
//	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
//		prod_svc.delete(prod_svc.findById(id));
//	    return ResponseEntity.ok("Deletion success");
//	}
}

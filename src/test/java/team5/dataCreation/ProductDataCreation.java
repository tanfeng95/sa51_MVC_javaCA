package team5.dataCreation;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import team5.model.Product;
import team5.repo.FixsetDetailsRepo;
import team5.repo.FixsetRepo;
import team5.repo.ProductRepo;
import team5.repo.StockTransactionRepo;
import team5.repo.UsageRecordRepo;
import team5.repo.UserRepo;

@SpringBootTest
public class ProductDataCreation {
	
	@Autowired
	public ProductRepo productRepo;
	@Autowired
	public UserRepo urepo;
	@Autowired
	public UsageRecordRepo usageRepo;
	@Autowired
	public StockTransactionRepo strepo;
	@Autowired
	public FixsetRepo fixsetRepo;
	@Autowired
	public FixsetDetailsRepo fixsetDetailsRepo;
	
	@Test
	public void saveProduct() {
		productRepo.save(new Product(2345,"Collision Cart","The original high quality, low friction dynamics carts made from durable machined aluminum.",
									"Type A","Blue",200,"Category A", 2000 ,  3000, 1200, 2, 2, "12345" , 1, 1));
		productRepo.save(new Product(3432,"Large Table Clamp","Can attach to tables, shelves, or other boards up to 10 cm thick.",
				"Type B","Black",200,"Category B", 2500 ,  3000, 1260, 3, 2, "12345" , 1, 1));
		productRepo.save(new Product(5432,"Tension Protractor","ME-6855","Type C","White",500,"Category C", 8000 ,  3500, 1240, 6, 4, "2314" , 1, 4));
		
		productRepo.save(new Product(2345,"Collision Cart","The original high quality, low friction dynamics carts made from durable machined aluminum.",
									"Type A","Blue",200,"Category A", 2000 ,  3000, 1200, 2, 2, "12345" , 8, 3));
		productRepo.save(new Product(3432,"Large Table Clamp","Can attach to tables, shelves, or other boards up to 10 cm thick.",
				"Type B","Black",200,"Category B", 2500 ,  3000, 1260, 3, 2, "12345" , 8, 5));
		productRepo.save(new Product(5432,"Tension Protractor","ME-6855","Type C","White",500,"Category C", 8000 ,  3500, 1240, 6, 4, "2314" , 7, 4));
		productRepo.save(new Product(3452,"Jeep wheel","The best wheel for jeep.",
				"Type A","Black",200,"Category A", 2000 ,  3000, 1200, 2, 2, "12345" , 5, 2));
		productRepo.save(new Product(3433,"Large Table Clamp","Can attach to tables, shelves, or other boards up to 10 cm thick.",
				"Type B","Black",200,"Category B", 2500 ,  3000, 1260, 3, 2, "12345" , 6, 3));
		productRepo.save(new Product(5433,"Tension Protractor","ME-6855","Type C","White",500,"Category C", 8000 ,  3500, 1240, 6, 4, "2314" , 10, 4));
		productRepo.save(new Product(1000,"Tyre","ME-6855","Type C","Black",500,"Category C", 8000 ,  3500, 1240, 6, 4, "2314" , 10, 4));
		productRepo.save(new Product(1001,"Suspension","ME-6855","Type C","Silver",500,"Category B", 5000 ,  2000, 1500, 6, 4, "2314" , 10, 4));
		productRepo.save(new Product(1002,"Pedal","ME-6855","Type C","Gold",500,"Category B", 5000 ,  2000, 1500, 6, 4, "2314" , 10, 4));
		productRepo.save(new Product(1003,"Engine","ME-6855","Type C","Silver",500,"Category B", 5000 ,  2000, 1500, 6, 4, "2314" , 10, 4));
		
		ArrayList<Product> plist = new ArrayList<Product>();		
		plist = (ArrayList<Product>) productRepo.findAll();
		
		System.out.println("Print all products");
		for (Iterator<Product> iterator = plist.iterator(); iterator.hasNext();) {
			Product product =  iterator.next();
			System.out.println(product.toString());
		}
	}
}
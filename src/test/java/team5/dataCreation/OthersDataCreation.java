package team5.dataCreation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import team5.model.Fixset;
import team5.model.FixsetDetails;
import team5.model.Product;
import team5.model.StockTransaction;
import team5.model.UsageRecord;
import team5.model.User;
import team5.repo.FixsetDetailsRepo;
import team5.repo.FixsetRepo;
import team5.repo.ProductRepo;
import team5.repo.StockTransactionRepo;
import team5.repo.UsageRecordRepo;
import team5.repo.UserRepo;

@SpringBootTest
public class OthersDataCreation {
	
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
	public void saveUsageRecord() throws ParseException { 
		Product first = productRepo.findById((long)4); 
		Product second = productRepo.findById((long)2); 
		Product third = productRepo.findById((long)3);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		Date fDate = formatter.parse("01-12-2020"); 
		Date sDate = formatter.parse("03-12-2020");
		Date tDate = formatter.parse("05-12-2020"); 
		User admin1 = urepo.findById((long)1).get(); 
		UsageRecord oneR = usageRepo.save(new UsageRecord("john","SAA1235", fDate, admin1)); 
		UsageRecord secondR = usageRepo.save(new UsageRecord("Mary","SAB2345", sDate, admin1));
		usageRepo.save(new UsageRecord("Peter","SAC3456", tDate, admin1));
		strepo.save(new StockTransaction(first,oneR,3)); 
		strepo.save(new StockTransaction(second,oneR,3)); 
		strepo.save(new StockTransaction(third,secondR,3)); 
		strepo.save(new StockTransaction(first,secondR,3)); 
		strepo.save(new StockTransaction(third,oneR,3)); 
	  }
	 
	@Test
	public void createFixsets() {
		Fixset first = new Fixset("car","car repair");
		Fixset second = new Fixset("motor","motor repair");
		Fixset third = new Fixset("bicycle","bicycle repair");
		Product tyre = productRepo.findById((long)10);
		Product suspension = productRepo.findById((long)11);
		Product pedal = productRepo.findById((long)12);
		Product engine = productRepo.findById((long)13);
		FixsetDetails car1 = new FixsetDetails(tyre, 4);
		FixsetDetails car2 = new FixsetDetails(suspension, 4);
		FixsetDetails car3 = new FixsetDetails(engine, 1);
		first.addFixsetDetails(car1);
		first.addFixsetDetails(car2);
		first.addFixsetDetails(car3);
		FixsetDetails motor1 = new FixsetDetails(tyre, 2);
		FixsetDetails motor2 = new FixsetDetails(suspension, 2);
		FixsetDetails motor3 = new FixsetDetails(engine, 1);
		second.addFixsetDetails(motor1);
		second.addFixsetDetails(motor2);
		second.addFixsetDetails(motor3);
		FixsetDetails bicycle1 = new FixsetDetails(tyre, 2);
		FixsetDetails bicycle2 = new FixsetDetails(pedal, 2);
		third.addFixsetDetails(bicycle1);
		third.addFixsetDetails(bicycle2);
		fixsetDetailsRepo.save(car1);
		fixsetDetailsRepo.save(car2);
		fixsetDetailsRepo.save(car3);
		fixsetDetailsRepo.save(motor1);
		fixsetDetailsRepo.save(motor2);
		fixsetDetailsRepo.save(motor3);
		fixsetDetailsRepo.save(bicycle1);
		fixsetDetailsRepo.save(bicycle2);
		fixsetRepo.save(first);
		fixsetRepo.save(second);
		fixsetRepo.save(third);
	
	}
}

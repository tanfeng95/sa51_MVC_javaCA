package team5.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class UsageRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String carPlate;
	@NotNull
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private Date date;

	private String comments;
	
	private String userName;
	@NotNull
	private String customerName;
	@OneToMany(mappedBy = "usageRecord")
	private List<StockTransaction> stockTranxList;

	public UsageRecord() {
		super();
	}

	public UsageRecord(String customerName, String carPlate, Date date, User user) {

		super();
		this.carPlate = carPlate;
		this.date = date;
		this.userName = user.getUserName();
		this.customerName = customerName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public List<StockTransaction> getStocktranx() {
		return stockTranxList;
	}

	public void setStocktranx(List<StockTransaction> stocktranx) {
		this.stockTranxList = stocktranx;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(User user) {
		this.userName = user.getUserName();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "UsageRecord [id=" + id + ", carPlate=" + carPlate + ", date=" + date + ", comments=" + comments
				+ ", userName=" + userName + ", customerName=" + customerName + ", usageRecordDetail="
				+ stockTranxList + "]";
	}
}

	

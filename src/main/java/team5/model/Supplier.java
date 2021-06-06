package team5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 2, max=100)
	private String supplierName;
	@NotNull
	@Size(min = 2, max=100)
	private String supplierAddress;
	@NotNull
	@Size(min = 2, max=100)
	private String phone;
	@NotNull
	@Size(min = 2, max=100)
	private String email;
	
	@OneToOne(mappedBy = "supplier")
	private Product  product;
	
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(String supplierName, String supplierAddress, String phone, String email) {
		super();
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.phone = phone;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}

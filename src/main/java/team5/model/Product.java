package team5.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Digits(integer = 8, fraction = 2)
	private long barcode;
	@NotNull
	@Size(min = 2, max=100)
	private String name;
	private String description;
	private String type;
	private String color;
	@Digits(integer = 8, fraction = 2)
	private long originalPrice;
	private String category;
	@Digits(integer = 8, fraction = 2)
	private long priceFWholesale;
	@Digits(integer = 8, fraction = 2)
	private long priceFRetail;
	@Digits(integer = 8, fraction = 2)
	private long PriceFPartner;
	private long subcategory;
	@Digits(integer = 8, fraction = 0, message = "Enter integer value")
	private long unit;
	private String partNumber;
	
	
	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	@JsonIgnore
	private List<FixsetDetails> fixsetDetailList;


	@OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
	@JsonIgnore
	private List<StockTransaction> stockTranxList;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="SUPP_ID")
	private Supplier supplier;

	private long reorderLevel;
    @Digits(integer = 8, fraction = 0)
	private long minReoderLevel;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(@Digits(integer = 8, fraction = 2) long barcode, @Size(min = 2, max = 100) String name) {
		super();
		this.barcode = barcode;
		this.name = name;
	}
	
	public Product(long barcode, String name, String description, String type, String color,
			long originalPrice, String category, long priceFWholesale, long priceFRetail, long priceFPartner,
			long subcategory, long unit, String partNumber, Supplier supplier, long reorderLevel, long minReoderLevel) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.type = type;
		this.color = color;
		this.originalPrice = originalPrice;
		this.category = category;
		this.priceFWholesale = priceFWholesale;
		this.priceFRetail = priceFRetail;
		PriceFPartner = priceFPartner;
		this.subcategory = subcategory;
		this.unit = unit;
		this.partNumber = partNumber;
		this.supplier = supplier;
		this.reorderLevel = reorderLevel;
		this.minReoderLevel = minReoderLevel;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", barcode=" + barcode + ", name=" + name + ", description=" + description
				+ ", type=" + type + ", color=" + color + ", originalPrice=" + originalPrice + ", category=" + category
				+ ", priceFWholesale=" + priceFWholesale + ", priceFRetail=" + priceFRetail + ", PriceFPartner="
				+ PriceFPartner + ", subcategory=" + subcategory + ", unit=" + unit + ", partNumber=" + partNumber
				+ ", supplier=" + supplier + ", reorderLevel=" + reorderLevel + ", minReoderLevel=" + minReoderLevel
				+ "]";
	}

	
	public Product(long barcode, String name, String description, String type, String color, long originalPrice,
			String category, long priceFWholesale, long priceFRetail, long priceFPartner, long subcategory, long unit,
			String partNumber, long reorderLevel, long minReoderLevel) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.description = description;
		this.type = type;
		this.color = color;
		this.originalPrice = originalPrice;
		this.category = category;
		this.priceFWholesale = priceFWholesale;
		this.priceFRetail = priceFRetail;
		PriceFPartner = priceFPartner;
		this.subcategory = subcategory;
		this.unit = unit;
		this.partNumber = partNumber;
		this.reorderLevel = reorderLevel;
		this.minReoderLevel = minReoderLevel;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBarcode() {
		return barcode;
	}
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(long originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getPriceFWholesale() {
		return priceFWholesale;
	}
	public void setPriceFWholesale(long priceFWholesale) {
		this.priceFWholesale = priceFWholesale;
	}
	public long getPriceFRetail() {
		return priceFRetail;
	}
	public void setPriceFRetail(long priceFRetail) {
		this.priceFRetail = priceFRetail;
	}
	public long getPriceFPartner() {
		return PriceFPartner;
	}
	public void setPriceFPartner(long priceFPartner) {
		PriceFPartner = priceFPartner;
	}
	public long getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(long subcategory) {
		this.subcategory = subcategory;
	}
	public long getUnit() {
		return unit;
	}
	public void setUnit(long unit) {
		this.unit = unit;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public long getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(long reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public long getMinReoderLevel() {
		return minReoderLevel;
	}
	public void setMinReoderLevel(long minReoderLevel) {
		this.minReoderLevel = minReoderLevel;
	}
	
	@JsonIgnore
	public List<StockTransaction> getStockTranxList() {
		return stockTranxList;
	}

	@JsonIgnore
	public void setStockTranxList(List<StockTransaction> stockTranxList) {
		this.stockTranxList = stockTranxList;
	}

	@JsonIgnore
	public List<FixsetDetails> getFixsetDetailList() {
		return fixsetDetailList;
	}

	@JsonIgnore
	public void setFixsetDetailList(List<FixsetDetails> fixsetDetailList) {
		this.fixsetDetailList = fixsetDetailList;
	}





}

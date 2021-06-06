package team5.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class ProductMapForm {
	private long id;
	private long barcode;
	private String name;
	private String description;
	private String type;
	private String color;
	private long originalPrice;
	private String category;
	private long priceFWholesale;
	private long priceFRetail;
	private long PriceFPartner;
	private long subcategory;
	private long unit;
	private String partNumber;
	private List<StockTransaction> stockTranxList;
	private Supplier supplier;
	private long reorderLevel;
	private long minReoderLevel;
	private long quantityUsed;
	
	public ProductMapForm() {
		super();
	}
	
	public ProductMapForm(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.color = product.getColor();
		this.unit = product.getUnit();
		this.partNumber = product.getPartNumber();
		this.quantityUsed = 0;
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



	public long getQuantityUsed() {
		return quantityUsed;
	}

	public void setQuantityUsed(long quantityUsed) {
		this.quantityUsed = quantityUsed;
	}

	@Override
	public String toString() {
		return "ProductMapForm [id=" + id + ", barcode=" + barcode + ", name=" + name + ", description=" + description
				+ ", type=" + type + ", color=" + color + ", originalPrice=" + originalPrice + ", category=" + category
				+ ", priceFWholesale=" + priceFWholesale + ", priceFRetail=" + priceFRetail + ", PriceFPartner="
				+ PriceFPartner + ", subcategory=" + subcategory + ", unit=" + unit + ", partNumber=" + partNumber
				+ ", usageDetailList=" + stockTranxList + ", supplier=" + supplier + ", reorderLevel=" + reorderLevel
				+ ", minReoderLevel=" + minReoderLevel + ", quantityUsed=" + quantityUsed + "]";
	}

	public List<StockTransaction> getStockTranxList() {
		return stockTranxList;
	}

	public void setStockTranxList(List<StockTransaction> stockTranxList) {
		this.stockTranxList = stockTranxList;
	}


	
	
}

package team5.nonEntityModel;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(Long id){
		super("Cound not find product with id: " + id);
	}
}

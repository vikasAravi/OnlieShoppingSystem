package ServiceLayer;

import java.util.HashMap;
import java.util.List;

import ControllerLayer.Product;

public interface ProductService {
	/**
	 * It Provides services to products/Items
	 */
	public void addProduct(Product product);
	
	public void delProduct(String productId);
	
	public void updateProduct(String productId, Product product);
	
	public boolean isValidProduct(String productId);
	
	public Product searchByID(String productId);
	
	public List<Product> searchByName(String productName);
	
	public List<Product> searchByPrice(double lowerPriceRange, double upperPriceRange);
	
	public HashMap<String, Product> displayAllProducts();

	
}

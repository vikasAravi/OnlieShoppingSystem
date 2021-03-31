package ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ControllerLayer.Product;
import DB.ProductDB;
import ServiceLayer.ProductService;

public class ProductImpl implements ProductService {
	/**
	 * implements all the product servives and persist the data in productDB
	 */
	
	ProductDB prodDB = new ProductDB();
	HashMap<String, Product> productDetails;
	
	public boolean isValidProduct(String productID) {
		productDetails = prodDB.getProductDetails();
		if(productDetails.containsKey(productID) == true) {
			return true;
		}
		return false;
	}

	@Override
	public void addProduct(Product product) {
		productDetails = prodDB.getProductDetails();
		productDetails.put(product.getProductId(), product);
	}

	@Override
	public void delProduct(String productId) {
		productDetails = prodDB.getProductDetails();
		productDetails.remove(productId);
		prodDB.setProductDetails(productDetails);
	}

	@Override
	public void updateProduct(String productId, Product product) {
		productDetails = prodDB.getProductDetails();
		//TODO update the product
		productDetails.remove(productId);
		productDetails.put(productId, product);
	}

	@Override
	public Product searchByID(String productId) {
		productDetails = prodDB.getProductDetails();
		if(productDetails.containsKey(productId)) {
			System.out.println("Product found");
			return productDetails.get(productId);
		}
		return null;
	}

	@Override
	public List<Product> searchByName(String productName) {

		List<Product> productsByName = new ArrayList<>();
		prodDB = new ProductDB();
		productDetails = prodDB.getProductDetails();
		for(String productId: productDetails.keySet()) {
			Product prod = productDetails.get(productId);
			if(prod.getProductName().equalsIgnoreCase(productName))
				productsByName.add(prod);
		}
		return productsByName;
	}

	@Override
	public List<Product> searchByPrice(double lowerPriceRange, double upperPriceRange) {
		List<Product> productsByName = new ArrayList<>();
		prodDB = new ProductDB();
		productDetails = prodDB.getProductDetails();
		for(String productId: productDetails.keySet()) {
			Product prod = productDetails.get(productId);
			if(prod.getCost() >= lowerPriceRange && prod.getCost() <= upperPriceRange)
				productsByName.add(prod);
		}
		return productsByName;
	}
	
	@Override
	public HashMap<String, Product> displayAllProducts() {
		productDetails = prodDB.getProductDetails();
		return productDetails;
	}
	
	
}

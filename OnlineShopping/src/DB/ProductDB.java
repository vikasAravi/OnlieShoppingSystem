package DB;

import java.util.HashMap;

import ControllerLayer.Product;

public class ProductDB {
	/**
	 * Stores the Product Information in HashMap with "ProductId" as the key 
	 */
	private static HashMap<String, Product> productDetails = new HashMap<>();

	/**
	 * @return the productDetails
	 */
	public HashMap<String, Product> getProductDetails() {
		return productDetails;
	}

	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(HashMap<String, Product> productDetails) {
		ProductDB.productDetails = productDetails;
	}
	
	
}

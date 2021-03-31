package MainPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import ControllerLayer.Product;
import ServiceImpl.ProductImpl;

public class AdminController {

	Scanner sc = new Scanner(System.in);

	public void addProduct() {
		System.out.println("Please fill up the below information to add the product");
		System.out.println();
		Product product = new Product();
		ProductImpl prodImpl = new ProductImpl();

		System.out.println("Enter Product Id");
		System.out.println();
		String productId = sc.next();

		System.out.println("Enter Product Name");
		System.out.println();
		String productName = sc.next();

		System.out.println("Enter Description");
		System.out.println();
		String description = sc.next();

		System.out.println("Enter Price");
		System.out.println();
		double price = sc.nextDouble();

		product.setCost(price);
		product.setDescription(description);
		product.setProductId(productId);
		product.setProductName(productName);

		boolean isValidProduct = prodImpl.isValidProduct(productId);

		if (!isValidProduct) {
			prodImpl.addProduct(product);
			System.out.println("Product Added Successfully");
		}

		else {
			System.out.println("Product Id already existed");
		}

	}

	public void deleteProduct() {
		ProductImpl prodImpl = new ProductImpl();

		System.out.println("Please fill up the below information to delete the product");
		System.out.println();

		System.out.println("Enter Product Id");
		String productId = sc.next();

		boolean isValidProduct = prodImpl.isValidProduct(productId);

		if (isValidProduct) {
			prodImpl.delProduct(productId);
			System.out.println("Product Deleted Successfully");
		}

		else {
			System.out.println("No Product with this Id");
		}
	}

	public void updateProduct() {
		ProductImpl prodImpl = new ProductImpl();
		Product product = new Product();

		System.out.println("Please fill up the below information to delete the product");
		System.out.println();

		System.out.println("Enter Product Id");
		System.out.println();
		String productId = sc.next();

		System.out.println("Enter Product Name");
		System.out.println();
		String productName = sc.next();

		System.out.println("Enter Description");
		System.out.println();
		String description = sc.next();

		System.out.println("Enter Price");
		System.out.println();
		double price = sc.nextDouble();

		product.setCost(price);
		product.setDescription(description);
		product.setProductId(productId);
		product.setProductName(productName);

		boolean isValidProduct = prodImpl.isValidProduct(productId);

		if (isValidProduct) {
			prodImpl.updateProduct(productId, product);
			System.out.println("Product updated Successfully");
		}

		else {
			System.out.println("No Product with this Id");
		}

	}
	
	public void searchById() {
		ProductImpl prodImpl = new ProductImpl();
		
		System.out.println("Please fill up the below information to search the product with Id");
		System.out.println();
		
		System.out.println("Enter Product Id");
		System.out.println();
		String productId = sc.next();
		
		boolean isValidProduct = prodImpl.isValidProduct(productId);
		
		if(isValidProduct == true) {
			Product productDetail = prodImpl.searchByID(productId);
			
			System.out.println("Information is");
			System.out.println("PRODUCT ID: " + productDetail.getProductId());
			System.out.println("PRODUCT NAME: " + productDetail.getProductName());
			System.out.println("PRODUCT DESCRIPTION: " + productDetail.getDescription());
			System.out.println("PRODUCT COST: " + productDetail.getCost());
		}
		
		else {
			System.out.println("Product Id not found");
		}
		
	}
	
	public void searchByName() {
		ProductImpl prodImpl = new ProductImpl();
		
		System.out.println("Please fill up the below information to search the product with name");
		System.out.println();
		
		System.out.println("Enter Product Name");
		System.out.println();
		String productName = sc.next();
		
		
		List<Product> productDetail = prodImpl.searchByName(productName);
		
		System.out.println("Information available");
		
		for(Product prod : productDetail) {
			System.out.println("PRODUCT ID: " + prod.getProductId());
			System.out.println("PRODUCT NAME: " + prod.getProductName());
			System.out.println("PRODUCT DESCRIPTION: " + prod.getDescription());
			System.out.println("PRODUCT COST: " + prod.getCost());
		}
	}
	
	public void searchByPrice() {
		ProductImpl prodImpl = new ProductImpl();
		
		System.out.println("Please fill up the below information to search the product with price");
		System.out.println();
		
		System.out.println("Enter Lower Range of Price");
		System.out.println();
		double lowerPrice = sc.nextDouble();
		
		System.out.println("Enter Higher Range of Price");
		System.out.println();
		double higherPrice = sc.nextDouble();
		
		
		
		
		
		
		List<Product> productDetail = prodImpl.searchByPrice(lowerPrice, higherPrice);
		
		System.out.println("Information available");
		
		for(Product prod : productDetail) {
			System.out.println("PRODUCT ID: " + prod.getProductId());
			System.out.println("PRODUCT NAME: " + prod.getProductName());
			System.out.println("PRODUCT DESCRIPTION: " + prod.getDescription());
			System.out.println("PRODUCT COST: " + prod.getCost());
		}
	}
	public void displayProducts() {
		ProductImpl prodImpl = new ProductImpl();
		
		HashMap<String, Product> prods = prodImpl.displayAllProducts();
		
		System.out.println("Products available");
		for(String prodId: prods.keySet()) {
			Product product = prods.get(prodId);
			System.out.print("Product ID: " + product.getProductId() + " " + "Product Name: " + 
			product.getProductName() + " " + "Product Description: " + product.getDescription() + " " +
					"Product Cost: " + product.getCost());
			System.out.println();
		}
	}
}

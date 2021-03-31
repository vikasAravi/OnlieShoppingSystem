package MainPackage;

import java.util.Scanner;

import ControllerLayer.Cart;

public class MainController {

	static Scanner sc = new Scanner(System.in);
	private static String cacheUser = null;

	public static void adminChoices() {
		System.out.println("Press 1 for Adding Product");
		System.out.println("Press 2 for Delete Product");
		System.out.println("Press 3 for Update Product");
		System.out.println("Press 4 for search Product with ID");
		System.out.println("Press 5 for search Product With Name");
		System.out.println("Press 6 for search Produst by Price");
		System.out.println("Press 0 for logout");
		System.out.println();
	}

	public static void userChoices(boolean auth) {
		System.out.println("Press 0 for Logout");
		System.out.println("Press 1 for Account Creation");
		System.out.println("Press 2 for Login");
		if (auth == true)
			System.out.println("Press 3 for display Products");
		if (auth == true)
			System.out.println("Press 4 fro search Products with ID");
		if (auth == true)
			System.out.println("Press 5 for searching products with names");
		if (auth == true)
			System.out.println("Press 6 for searching products with price");
		if (auth == true)
			System.out.println("Press 7 for adding items to cart");
		if (auth == true)
			System.out.println("Press 8 for checkout");
		if (auth == true)
			System.out.println("Press 9 for show Order History");

	}

	public static void admin() {

		adminChoices();
		AdminController adminController = new AdminController();
		System.out.println("Enter Choice");
		String choice = sc.next();
		while (!choice.equals("0")) {
			if (choice.equals("1"))
				adminController.addProduct();
			else if (choice.equals("2"))
				adminController.deleteProduct();
			else if (choice.equals("3"))
				adminController.updateProduct();
			else if (choice.equals("4"))
				adminController.searchById();
			else if (choice.equals("5"))
				adminController.searchByName();
			else if (choice.equals("6"))
				adminController.searchByPrice();
			adminChoices();

			System.out.println("Enter Choice");
			choice = sc.next();
		}
	}

	public static void customer() {
		boolean auth = false;
		Cart cart = null;
		userChoices(auth);
		UserController userController = new UserController();
		AdminController adminController = new AdminController();
		System.out.println("Enter Choice");
		String choice = sc.next();
		while (!choice.equals("0")) {
			if (choice.equals("1"))
				userController.addAccount();
			else if (choice.equals("2")) {
				cacheUser = userController.loginAccount();
				if (cacheUser != null) {
					auth = true;
					System.out.println("Logged In");
				} else {
					System.out.println("Invalid Credentials");
				}
			}

			else if (choice.equals("3") && auth) {
				adminController.displayProducts();
			}

			else if (choice.equals("4") && auth) {
				adminController.searchById();
			}

			else if (choice.equals("5") && auth) {
				adminController.searchByName();
			} 
			
			else if (choice.equals("6") && auth) {
				adminController.searchByPrice();
			}
			
			else if (choice.equals("7") && auth) {
				cart = userController.addItemsToCart();
			}

			else if (choice.equals("8") && auth) {
				userController.checkout(cacheUser, cart);
				cart = null;
			}

			else if (choice.equals("9") && auth) {
				userController.displayOrders(cacheUser);
			}
			userChoices(auth);

			System.out.println("Enter Choice");
			choice = sc.next();

		}

		cacheUser = null;
	}

	public static void main(String[] args) {
		System.out.println("Press 1 for Admin");
		System.out.println("Press 2 for Customer");
		System.out.println("Enter Choice 1/2");
		String choice = sc.next();
		if (choice.equals("1"))
			admin();
		else if (choice.equals("2"))
			customer();
		main(args);

	}

}

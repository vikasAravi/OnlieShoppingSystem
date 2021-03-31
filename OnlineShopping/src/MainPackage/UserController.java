package MainPackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import ControllerLayer.AccountController;
import ControllerLayer.Address;
import ControllerLayer.Cart;
import ControllerLayer.Item;
import ControllerLayer.Order;
import ControllerLayer.Product;
import ServiceImpl.AccountImpl;
import ServiceImpl.OrderImpl;
import ServiceImpl.ProductImpl;

public class UserController {
	
	
	Scanner sc = new Scanner(System.in);
	
	public void addAccount() {
		System.out.println("Enter Account Information");
		System.out.println();
		
		AccountController acct = new AccountController();
		
		System.out.println("Enter User Name");
		String userName = sc.next();
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		System.out.println("Enter DOB");
		String DOB = sc.next();
		
		System.out.println("Enter phoneNumber");
		String phoneNumber = sc.next();
		
		System.out.println("Enter Address");
		
		System.out.println("Enter doorNo");
		String dNo = sc.next();
		
		System.out.println("Enter landmark");
		String landmark = sc.next();
		
		System.out.println("Enter mandal");
		String mandal = sc.next();
		
		System.out.println("Enter district");
		String district = sc.next();
		
		System.out.println("Enter State");
		String state = sc.next();
		
		System.out.println("Enter Country");
		String country = sc.next();
		
		System.out.println("Enter pincode");
		String pincode = sc.next();
		
		AccountImpl acctImpl = new AccountImpl();
		
		Address address = new Address();
		
		address.setCountry(country);
		address.setDistrict(district);
		address.setDNo(dNo);
		address.setLandmark(landmark);
		address.setMandal(mandal);
		address.setPinCode(pincode);
		address.setState(state);
		
		acct.setDOB(DOB);
		acct.setEmail(email);
		acct.setPassword(password);
		acct.setPhoneNumber(phoneNumber);
		acct.setUserName(userName);
		acct.setAddress(address);
		
		
		boolean isValidAccount = acctImpl.isValidAccountDetail(acct);
		
		if(isValidAccount) {
			acctImpl.addAccount(acct);
//			displayUsers();
		}
		
		else {
			System.out.println("User Name already Existed");
		}
		
	}
	
	public String loginAccount() {
		System.out.println("Enter Login Information");
		System.out.println();
		
		System.out.println("Enter User Name");
		String userName = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		AccountImpl acctImpl = new AccountImpl();
		
		boolean isValidCredentials = acctImpl.isValidCredentials(userName, password);
			
		if(isValidCredentials) {
			return userName;
		}
		return null;
		
	}
	
	public void displayUsers() {
		
		AccountImpl acctImpl = new AccountImpl();
		
		HashMap<String, AccountController> userInfo = acctImpl.displayAllAccount();
		
		for(String userName : userInfo.keySet()) {
			System.out.println("User Name: " + userName);
			
			AccountController acct = userInfo.get(userName);
			
			System.out.println("User Email: " + acct.getEmail());
			System.out.println("User Password: " + acct.getPassword());
			System.out.println("User DOB: " + acct.getDOB());
			System.out.println("User phoneNumber: " + acct.getPhoneNumber());
		}
	}
	
	
	
//	public void delAccount() {
//		
//	}
//	
//	public void updateAccount() {
//		//TODO
//	}
	
	public Cart addItemsToCart() {
		Cart cart = new Cart();
		List<Item> itemstoCart = new ArrayList<>();
		System.out.println("Enter Product Id's with space seperation");
		sc.nextLine();
		String ids = sc.nextLine();
		String[] prodIds = ids.split(" ");
		System.out.println("Enter Product Id Quantities with space seperation");
		String quans = sc.nextLine();
		String[] quantities = quans.split(" ");
		for(int i = 0; i < prodIds.length; i++) {
			Item item = new Item();
			item.setProductID(prodIds[i]);
			item.setQuantity(Integer.parseInt(quantities[i]));
			
			itemstoCart.add(item);
		}
		cart.setCartItems(itemstoCart);
		return cart;
	}
	
	public void checkout(String user, Cart cart) {
		String orderId = "0";
		Order order = new Order();
		ProductImpl prodImpl = new ProductImpl();
		OrderImpl orderImpl = new OrderImpl();
		List<Item> cartItems = cart.getCartItems();
		double totalAmount = 0;
		System.out.println("Cart Information");
		for(Item item : cartItems) {
			String productId = item.getProductID();
			int quantity = item.getQuantity();
			Product prod = prodImpl.searchByID(productId);
			double price = prod.getCost() * quantity;
			String productName = prod.getProductName();
			totalAmount += price;
			System.out.println("Product Id: " + productId + " " + "Quantity: " + quantity + " " + 
			"Product Name: " + productName +  "Cost: " + price);
			
			
		}
		System.out.println("TOTAL AMOUNT: " + totalAmount);
		order.setCreationDate(new Date());
		order.setOrderID(orderId);
		orderId.concat("0");
		order.setOrderName("Ordered");
		order.setOrderStatus(null);
		order.setCart(cart);
		
		
		orderImpl.addProductHistory(user, order);
		System.out.println("Hsitory added to the order DB");
	}
	
	public void displayOrders(String userName) {
		OrderImpl orderImpl = new OrderImpl();
		List<Order> orderHistory = orderImpl.getUserOrders(userName);
		for(Order order: orderHistory) {
			System.out.println("Order ID: " + order.getOrderID());
			List<Item> items = order.getCart().getCartItems();
			for(Item item : items) {
				System.out.println("PRODUCT ID: " + item.getProductID());
			}
		}
	}
}

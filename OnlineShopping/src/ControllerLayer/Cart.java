package ControllerLayer;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Item> cartItems = new ArrayList<>();

	/**
	 * @return the cartItems
	 */
	public List<Item> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	
}

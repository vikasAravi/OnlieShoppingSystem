package DB;

import java.util.HashMap;
import java.util.List;

import ControllerLayer.Order;

public class OrdersDB {
	
	private static HashMap<String, List<Order>> orderHistory = new HashMap<>();

	/**
	 * @return the orderHistory
	 */
	public HashMap<String, List<Order>> getOrderHistory() {
		return orderHistory;
	}

	/**
	 * @param orderHistory the orderHistory to set
	 */
	public void setOrderHistory(HashMap<String, List<Order>> orderHistory) {
		OrdersDB.orderHistory = orderHistory;
	}

		
}

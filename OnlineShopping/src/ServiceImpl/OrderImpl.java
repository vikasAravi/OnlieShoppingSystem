package ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ControllerLayer.Order;
import DB.OrdersDB;
import ServiceLayer.OrderService;

public class OrderImpl implements OrderService {

	OrdersDB ordersDB =  new OrdersDB();;
	
	HashMap<String, List<Order>> orderHistory;
	
	@Override
	public void addProductHistory(String userName, Order order) {
		orderHistory = ordersDB.getOrderHistory();
		if(orderHistory.containsKey(userName)) {
			orderHistory.get(userName).add(order);
		}
		else {
			List<Order> orders = new ArrayList<>();
			orders.add(order);
			orderHistory.put(userName, orders);
		}
	}
	
	@Override
	public List<Order> getUserOrders(String userName){
		orderHistory = ordersDB.getOrderHistory();
		List<Order> orders = orderHistory.get(userName);
		return orders;
	}

}

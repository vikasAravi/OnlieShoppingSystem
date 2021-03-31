package ServiceLayer;

import java.util.List;

import ControllerLayer.Order;

public interface OrderService {
	
	void addProductHistory(String userName, Order order);
	
	List<Order> getUserOrders(String userName);
}

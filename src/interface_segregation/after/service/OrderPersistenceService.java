package interface_segregation.after.service;

import java.util.HashMap;
import java.util.Map;

import interface_segregation.before.entity.Order;

public class OrderPersistenceService implements PersistenceService<Order> {

	private final static Map<Long, Order> orders = new HashMap<Long, Order>();

	@Override
	public void save(Order order) {
		orders.put(order.getId(), order);

	}

	@Override
	public void delete(Order order) {
		orders.remove(order.getId());

	}

	@Override
	public Order findById(Long id) {
		return orders.get(id);
	}

	public static Map<Long, Order> getOrders() {
		return orders;
	}

}

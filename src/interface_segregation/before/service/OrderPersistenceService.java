package interface_segregation.before.service;

import java.util.HashMap;
import java.util.List;
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

	// we can't implement this method because this class can't use it
	@Override
	public List<Order> findByName(String name) {
		throw new UnsupportedOperationException();
	}

	public static Map<Long, Order> getOrders() {
		return orders;
	}

}

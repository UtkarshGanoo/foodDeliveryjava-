package com.foodie.Dao;
import java.util.List;
import com.foodie.model.*;


public interface OrderDao {
	void addOrder(Order order);
	Order getOrder(int orderId);
	List<Order> getallOrder();
	void update_Order(Order order);
	void delete_Order(int orderId);
}

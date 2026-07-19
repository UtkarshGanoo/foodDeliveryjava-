package com.foodie.Dao;

import java.util.List;

import com.foodie.model.Orderhistory;

public interface OrderHistoryDao {
	void addOrderHistory(Orderhistory orderhistory);
	Orderhistory getOrderHistory(int orderHistoryId);
	List<Orderhistory> getAllOrderHistory();
	void updateOrderHistory(Orderhistory orderhistory);
	void deleteOrderHistory(int orderHistoryId);
}

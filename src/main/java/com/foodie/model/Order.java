package com.foodie.model;

import java.time.LocalDateTime;

public class Order {
	
	private int orderId;
	private int restaurantId;
	private int userId;
	private double totalAmount;
	private String ModeOfPayment;
	private String orderStatus;
	private LocalDateTime orderDate;
	private String orderAddress;
	
	
	public Order() {}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getModeOfPayment() {
		return ModeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		ModeOfPayment = modeOfPayment;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderAddress() {
		return orderAddress;
	}


	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}


	public Order(int orderId, int restaurantId, int userId, double totalAmount, String modeOfPayment,
			String orderStatus, LocalDateTime orderDate, String orderAddress) {
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.ModeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
	}
	public Order( int restaurantId, int userId, double totalAmount, String modeOfPayment,
			String orderStatus, LocalDateTime orderDate, String orderAddress) {
		
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.ModeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
		
	}
	
	
	
	
}


package com.foodie.model;

public class Orderhistory {
private int orderHistoryId;
private int Order_Id;
private int User_Id;

	public Orderhistory() {
	
	}

	public Orderhistory(int orderHistoryId, int Order_Id, int User_Id) {
		this.orderHistoryId = orderHistoryId;
		this.Order_Id = Order_Id;
		this.User_Id = User_Id;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	
	public int getOrder_Id() {
		return Order_Id;
	}
	
	public void setOrder_Id(int Order_Id) {
		this.Order_Id = Order_Id;
	}
	
	public int getUser_Id() {
		return User_Id;
	}
	
	public void setUser_Id(int User_Id) {
		this.User_Id = User_Id;
	}


}


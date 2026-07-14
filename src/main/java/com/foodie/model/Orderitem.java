package com.foodie.model;

public class Orderitem {
	private int orderItemId;
	private int orderUserItemId;
	private int orderItemMenuId;
	private String orderItemName;
	private double orderItemRating;
	private int orderItemQuantity;
	private double orderItemPrice;
	
	public Orderitem() {}

	public Orderitem(int orderItemId, int orderUserItemId, int orderItemMenuId, String oderItemName,
			double orderItemRating, int orderItemQuantity, double orderItemPrice) {
		super();
		this.orderItemId = orderItemId;
		this.orderUserItemId = orderUserItemId;
		this.orderItemMenuId = orderItemMenuId;
		this.orderItemName = oderItemName;
		this.orderItemRating = orderItemRating;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemPrice = orderItemPrice;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderUserItemId() {
		return orderUserItemId;
	}

	public void setOrderUserItemId(int orderUserItemId) {
		this.orderUserItemId = orderUserItemId;
	}

	public int getOrderItemMenuId() {
		return orderItemMenuId;
	}

	public void setOrderItemMenuId(int orderItemMenuId) {
		this.orderItemMenuId = orderItemMenuId;
	}

	public String getOrderItemName() {
		return orderItemName;
	}

	public void setOrderItemName(String oderItemName) {
		this.orderItemName = oderItemName;
	}

	public double getOrderItemRating() {
		return orderItemRating;
	}

	public void setOrderItemRating(double orderItemRating) {
		this.orderItemRating = orderItemRating;
	}

	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}

	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}

	public double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public Orderitem(int orderUserItemId, int orderItemMenuId, String oderItemName, double orderItemRating,
			int orderItemQuantity, double orderItemPrice) {
		super();
		this.orderUserItemId = orderUserItemId;
		this.orderItemMenuId = orderItemMenuId;
		this.orderItemName = oderItemName;
		this.orderItemRating = orderItemRating;
		this.orderItemQuantity = orderItemQuantity;
		this.orderItemPrice = orderItemPrice;
	}
	
	
	
	
	

}

package com.foodie.model;

public class Restaurant {
	
	// to store the database from the database 
	private int Restaurant_Id;
	private String Restaurant_Name;
	private String Image_path;
	private float Rating;
	private String ETA;
	private String CuisineType;
	private String Address;
	private Boolean IsActive;
	private int Restaurant_OwnerId;
	
	//here we created default constructor
	public Restaurant() 
	{
		
	}
	
	//here we created the parameterized constructor to get the details from the database
	public Restaurant(int Restaurant_Id, String Restaurant_Name, String Image_path, float Rating, String ETA,
			String CuisineType, String Address, Boolean IsActive, int Restaurant_OwnerId) {
	
		this.Restaurant_Id = Restaurant_Id;
		this.Restaurant_Name = Restaurant_Name;
		this.Image_path = Image_path;
		this.Rating = Rating;
		this.ETA = ETA;
		this.CuisineType = CuisineType;
		this.Address = Address;
		this.IsActive = IsActive;
		this.Restaurant_OwnerId = Restaurant_OwnerId;
	}

	//here are the getters and setters
	public int getRestaurant_Id() {
		return Restaurant_Id;
	}


	public void setRestaurant_Id(int restaurant_Id) {
		Restaurant_Id = restaurant_Id;
	}


	public String getRestaurant_Name() {
		return Restaurant_Name;
	}


	public void setRestaurant_Name(String restaurant_Name) {
		Restaurant_Name = restaurant_Name;
	}


	public String getImage_path() {
		return Image_path;
	}


	public void setImage_path(String image_path) {
		Image_path = image_path;
	}


	public float getRating() {
		return Rating;
	}


	public void setRating(float rating) {
		Rating = rating;
	}


	public String getETA() {
		return ETA;
	}


	public void setETA(String eTA) {
		ETA = eTA;
	}


	public String getCuisineType() {
		return CuisineType;
	}


	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public Boolean getIsActive() {
		return IsActive;
	}


	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}


	public int getRestaurant_OwnerId() {
		return Restaurant_OwnerId;
	}


	public void setRestaurant_OwnerId(int restaurant_OwnerId) {
		Restaurant_OwnerId = restaurant_OwnerId;
	}
	
	
}

package com.foodie.model;

public class Menu {
	private int menuItem_Id;
	private String menuItem_Name;
	private String menuItem_ImagePath;
	private double menuItem_Cost;
	private String menuItem_Description;
	private boolean menuItem_Status;
	private double menuItem_Rating;
	private int RestaurantmenuItem_Id;
	
	public Menu() 
	{
		
	}

	public Menu(int menuItem_Id, String menuItem_Name, String menuItem_ImagePath, double menuItem_Cost,
			String menuItem_Description, boolean menuItem_Status, double menuItem_Rating,
			int RestaurantmenuItem_Id) {
		this.menuItem_Id = menuItem_Id;
		this.menuItem_Name = menuItem_Name;
		this.menuItem_Cost = menuItem_Cost;
		this.menuItem_ImagePath = menuItem_ImagePath;
		this.menuItem_Description = menuItem_Description;
		this.menuItem_Status = menuItem_Status;
		this.menuItem_Rating = menuItem_Rating;
		this.RestaurantmenuItem_Id = RestaurantmenuItem_Id;
	}
	
	//to dont want to pass the id's everytime thats why we cretae this  
	public Menu(String menuItem_Name,
            double menuItem_Cost,
            String menuItem_ImagePath,
            String menuItem_Description,
            boolean menuItem_Status,
            double menuItem_Rating){
    this.menuItem_Name = menuItem_Name;
    this.menuItem_Cost = menuItem_Cost;
    this.menuItem_ImagePath = menuItem_ImagePath;
    this.menuItem_Description = menuItem_Description;
    this.menuItem_Status = menuItem_Status;
    this.menuItem_Rating = menuItem_Rating;
}

	public int getMenuItem_Id() {
		return menuItem_Id;
	}

	public void setMenuItem_Id(int menuItem_Id) {
		this.menuItem_Id = menuItem_Id;
	}

	public String getMenuItem_Name() {
		return menuItem_Name;
	}

	public void setMenuItem_Name(String menuItem_Name) {
		this.menuItem_Name = menuItem_Name;
	}

	public String getMenuItem_ImagePath() {
		return menuItem_ImagePath;
	}

	public void setMenuItem_ImagePath(String menuItem_ImagePath) {
		this.menuItem_ImagePath = menuItem_ImagePath;
	}

	public double getMenuItem_Cost() {
		return menuItem_Cost;
	}

	public void setMenuItem_Cost(double menuItem_Cost) {
		this.menuItem_Cost = menuItem_Cost;
	}

	public String getMenuItem_Description() {
		return menuItem_Description;
	}

	public void setMenuItem_Description(String menuItem_Description) {
		this.menuItem_Description = menuItem_Description;
	}

	public boolean isMenuItem_Status() {
		return menuItem_Status;
	}

	public void setMenuItem_Status(boolean menuItem_Status) {
		this.menuItem_Status = menuItem_Status;
	}

	public double getMenuItem_Rating() {
		return menuItem_Rating;
	}

	public void setMenuItem_Rating(double menuItem_Rating) {
		this.menuItem_Rating = menuItem_Rating;
	}

	public int getRestaurantmenuItem_Id() {
		return RestaurantmenuItem_Id;
	}

	public void setRestaurantmenuItem_Id(int RestaurantmenuItem_Id) {
		this.RestaurantmenuItem_Id = RestaurantmenuItem_Id;
	}
	
	
	
	
}

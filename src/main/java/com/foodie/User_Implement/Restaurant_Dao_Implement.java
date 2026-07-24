package com.foodie.User_Implement;
import com.foodie.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodie.Dao.*;

public class Restaurant_Dao_Implement implements RestaurantDao
{
	//here we create the refrences of connections 
	private Connection connection =null;
	private ResultSet result=null;
	private PreparedStatement statement=null;
	
//here we write all the qury
	final static String RestaurantAdd_Query="INSERT INTO `restaurantdetails` (`Restaurant_Name`,`ImagePath`,`Rating`,`ETA`,`CuisineType`,`Address`,`IsActive`,`OwnerId`)"+
											"VALUES(?,?,?,?,?,?,?,?)";
	final static String Get_RestaurantIdQuery="SELECT * FROM `restaurantdetails` WHERE restaurant_Id=?";
	
	final static String Get_RestaurantQuery="SELECT * FROM `restaurantdetails` ";
	
	final static String Update_RestaurantQuery="UPDATE `restaurantdetails` SET  `Restaurant_Name`=?,`ImagePath`=?,`Rating`=?,`ETA`=?,`CuisineType`=?,`Address`=?,`IsActive`=? WHERE `restaurant_Id`=?";
	
	final static String Delete_RestaurantQuery="DELETE FROM `restaurantdetails` WHERE `restaurant_Id`=?";
	
	
	public static void main(String[] args) 
	{
		RestaurantDao restsurantdao = new Restaurant_Dao_Implement();
		Restaurant restaurant = new Restaurant();
		
	/*	restaurant.setRestaurant_Name("amar sweets");
		restaurant.setImage_path("c://users/UTKASRHGANOO/amarlogo.jpeg");
		restaurant.setRating(4);
		restaurant.setETA("20 -40 min");
		restaurant.setCuisineType("sweets");
		restaurant.setAddress("bavadiya near vikas nagar dewas mp");
		restaurant.setIsActive(false);
		restaurant.setRestaurant_OwnerId(1);
		
		restsurantdao.addRestaurant(restaurant);*/
		
		/*restsurantdao.getRestaurant(1);*/
		
		/*restsurantdao.getallRestaurant();*/
		
		restaurant.setRestaurant_Name("Padmavati bhojnalaya ");
		restaurant.setImage_path("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQosSn_q7Xzw16drzlcVzit_SNftX8R0EdUvS5YsTjuPEcnFA7CtiZLQDI&s");
		restaurant.setRating(5);
		restaurant.setETA("10-20 min");
		restaurant.setCuisineType("SouthIndian,Indian,chinese");
		restaurant.setAddress("gokuldham socity Powdergali Near Filmcity Goregaon East,mumbai");
		restaurant.setIsActive(false);
		restaurant.setRestaurant_Id(1);
		restsurantdao.update_Restaurant(restaurant);

	}
	
// this constructor is handle the connection credential 
	public Restaurant_Dao_Implement() 
	{
	//here we create the datebase connection details 
		String url="jdbc:mysql://localhost:3306/fooddatabase";
		String username="root";
		String password="root";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("connection Established....." );
			
		}
		catch(SQLException |ClassNotFoundException  e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		try {
			statement=connection.prepareStatement(RestaurantAdd_Query);
			statement.setString(1,restaurant.getRestaurant_Name());
			statement.setString(2,restaurant.getImage_path());
			statement.setFloat(3,restaurant.getRating());
			statement.setString(4,restaurant.getETA());
			statement.setString(5,restaurant.getCuisineType());
			statement.setString(6,restaurant.getAddress());
			statement.setBoolean(7,restaurant.getIsActive());
			statement.setInt(8,restaurant.getRestaurant_OwnerId());
			int row =statement.executeUpdate();
			if(row>0) 
			{
				System.out.println("Restaurant added successfully.............!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			closeResources();
		}
	}

	@Override
	public Restaurant getRestaurant(int Restaurant_Id) {
		Restaurant restaurantDetail =null;
		try 
		{
			statement=connection.prepareStatement(Get_RestaurantIdQuery);
			statement.setInt(1,Restaurant_Id);
			result=statement.executeQuery();
			
			if(result.next())
			{
				int R_Id=result.getInt("Restaurant_Id");
				String R_name=result.getString("Restaurant_Name");
				String R_Imagepath=result.getString("ImagePath");
				float R_rating=result.getFloat("Rating");
				String R_Eta=result.getString("ETA");
				String R_CuisineTYPE=result.getString("CuisineType");
				String R_address=result.getString("Address");
				Boolean R_Status=result.getBoolean("IsActive");
				int R_OwnerId=result.getInt("OwnerId");
				
				System.out.println("Restaurant Id      : " + R_Id);
			    System.out.println("Restaurant_Name    : " + R_name);
			    System.out.println("ImagePath     	   : " + R_Imagepath);
			    System.out.println("Rating        	   : " + R_rating);
			    System.out.println("ETA        	   : " + R_Eta);
			    System.out.println("CuisineType 	   : " + R_CuisineTYPE);
			    System.out.println("Address            : " + R_address);
			    System.out.println("IsActive           : " + R_Status);
			    System.out.println("OwnerId            : " + R_OwnerId);


				restaurantDetail = new Restaurant(R_Id,R_name,R_Imagepath,R_rating,R_Eta,R_CuisineTYPE,R_address,R_Status,R_OwnerId);
				
			}
		} catch (Exception e) 
			{
			e.printStackTrace();
			}
		finally 
		{
			closeResources();
		}

		return restaurantDetail;
	}

	@Override
	public List<Restaurant> getallRestaurant() {
		ArrayList<Restaurant> restaurantDetail = new ArrayList<Restaurant>();
		try {
			statement =connection.prepareStatement(Get_RestaurantQuery);
			result=statement.executeQuery();
			while(result.next()) 
			{
				int R_Id=result.getInt("Restaurant_Id");
				String R_name=result.getString("Restaurant_Name");
				String R_Imagepath=result.getString("ImagePath");
				float R_rating=result.getFloat("Rating");
				String R_Eta=result.getString("ETA");
				String R_CuisineTYPE=result.getString("CuisineType");
				String R_address=result.getString("Address");
				Boolean R_Status=result.getBoolean("IsActive");
				int R_OwnerId=result.getInt("OwnerId");
				
				Restaurant rentDetail = new Restaurant(R_Id,R_name,R_Imagepath,R_rating,R_Eta,R_CuisineTYPE,R_address,R_Status,R_OwnerId);
				restaurantDetail.add(rentDetail);
			}
			for(Restaurant rdatils:restaurantDetail)
			{
				System.out.println(rdatils.getRestaurant_Id() +" | "+ rdatils.getRestaurant_Name()+" | "+rdatils.getImage_path()+" | "+
					    rdatils.getRating()+" | "+rdatils.getETA()+" | "+rdatils.getCuisineType()+" | "+rdatils.getAddress()+" | "+
					    rdatils.getIsActive()+" | "+rdatils.getRestaurant_OwnerId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			closeResources();
		}
		return restaurantDetail;
	}

	@Override
	public void update_Restaurant(Restaurant restaurant) {
		try 
		{
			statement= connection.prepareStatement(Update_RestaurantQuery);
			statement.setString(1,restaurant.getRestaurant_Name());
			statement.setString(2,restaurant.getImage_path());
			statement.setFloat(3,restaurant.getRating());
			statement.setString(4,restaurant.getETA());
			statement.setString(5,restaurant.getCuisineType());
			statement.setString(6,restaurant.getAddress());
			statement.setBoolean(7,restaurant.getIsActive());
			statement.setInt(8, restaurant.getRestaurant_Id());
			int row=statement.executeUpdate();
			if(row>0)
			{
			System.out.println("Restaurant Update Successfully.....!");	
			}else {
				System.out.println("Updation Failed...........!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			closeResources();
		}

		
	}

	@Override
	public void delete_Restaurant(int Restaurant_Id) {
		try 
		{
			
			statement= connection.prepareStatement(Delete_RestaurantQuery);
			statement.setInt(1, Restaurant_Id);
			int row=statement.executeUpdate();
			if(row>0)
			{
			System.out.println("Restaurant Deleted Successfully.....!");	
			}else {
				System.out.println("Error In Deletion...........!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			closeResources();
		}
		
	}
	
// here we create a method to close resource that is more easy and flexible and esay to use just call in finally block 
		private void closeResources() {
		    try {
		        if(result != null)
		            result.close();

		        if(statement != null)
		            statement.close();

		        if(connection != null)
		            connection.close();

		    } catch(SQLException e) {
		        e.printStackTrace();
		    }
		}

}

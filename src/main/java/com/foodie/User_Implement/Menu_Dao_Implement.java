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
public class Menu_Dao_Implement implements MenuDao {
	private ResultSet result;
	private Connection connection;
	private PreparedStatement statement;
	
	final static String MenuAdd_Query="INSERT INTO `menu_Table` (`item_Name`,`item_Cost`,`item_ImagePath`,`item_Description`,`item_Status`,`item_Rating`,`restaurantMenuItem_Id`)"+
			"VALUES(?,?,?,?,?,?,?)";
	final static String Get_MenuItemIdQuery="SELECT * FROM `menu_Table` WHERE menu_Id=?";

	final static String Get_FullMenuQuery="SELECT * FROM `menu_Table` ";

	final static String Update_MenuListQuery="UPDATE `menu_Table` SET  `item_Name`=?,`item_Cost`=?,`item_ImagePath`=?,`item_Description`=?,`item_Rating`=?, item_Status=? WHERE `menu_Id`=?";

	final static String Delete_MenuQuery="DELETE FROM `menu_Table` WHERE `menu_Id`=?";

	
	
	public static void main(String args[]) 
	{
		MenuDao menudao = new Menu_Dao_Implement();
		Menu menu = new Menu();
		
		/*menu.setMenuItem_Name("maxican");
		menu.setMenuItem_Cost(379.99);
		menu.setMenuItem_ImagePath("c://users/foodimages/img_78232114541.img");
		menu.setMenuItem_Description("a beutiful round pipe shape made with glow wheat dou");
		menu.setMenuItem_Status(true);
		menu.setMenuItem_Rating(4.2);
		menu.setRestaurantmenuItem_Id(1);
		menudao.addMenuItem(menu);*/
		
		/*menudao.getMenuItem(1);*/
		
		
	
		/*menudao.getallMenuItem();*/
		
		
		/*menu.setMenuItem_Name("paneer");
		menu.setMenuItem_Cost(149.99);
		menu.setMenuItem_ImagePath("c://users/foodimages/img_78232114541.img");
		menu.setMenuItem_Description("a milk processed cube with high protein ");
		menu.setMenuItem_Status(true);
		menu.setMenuItem_Rating(4.6);
		menu.setMenuItem_Id(1);
		menudao.update_MenuItem(menu);*/
		
		menudao.delete_MenuItem(2);
		
		
	}
	
	public Menu_Dao_Implement() {
		String url="jdbc:mysql://localhost:3306/fooddatabase";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =DriverManager.getConnection(url,username,password);
			System.out.println("connection established........!");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public void addMenuItem(Menu menu) {
		try {
			statement=connection.prepareStatement(MenuAdd_Query);
			statement.setString(1,menu.getMenuItem_Name());
			statement.setDouble(2,menu.getMenuItem_Cost());
			statement.setString(3,menu.getMenuItem_ImagePath());
			statement.setString(4,menu.getMenuItem_Description());
			statement.setBoolean(5,menu.isMenuItem_Status());
			statement.setDouble(6,menu.getMenuItem_Rating());
			statement.setInt(7,menu.getRestaurantmenuItem_Id());
			int row =statement.executeUpdate();
			if(row>0) 
			{
				System.out.println("Menu added successfully.............!");
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
	public Menu getMenuItem(int menuItem_Id) {
			Menu Menu_Details=new Menu();
			try {
				statement=connection.prepareStatement(Get_MenuItemIdQuery);
				statement.setInt(1, menuItem_Id);
				result=statement.executeQuery();
				
				if(result.next()) 
				{						
					/*fetch the user details from database and here we print in the console*/
				    System.out.println("MENUNAME         : " + result.getString("item_Name"));
				    System.out.println("MENUCOST         : " + result.getDouble("item_Cost"));
				    System.out.println("MENUIMAGE        : " + result.getString("item_ImagePath"));
				    System.out.println("MENUDESCRIPTION  : " + result.getString("item_Description"));
				    System.out.println("MENUSTATUS       : " + result.getBoolean("item_Status"));
				    System.out.println("MENURATING       : " + result.getDouble("item_Rating"));
				}
			} 
			
			catch (SQLException |NullPointerException e) 
			{
				
				e.printStackTrace();
			}
			finally 
			{
				closeResources();	
			}
					return Menu_Details;
}
	
	@Override
	public List<Menu> getallMenuItem() {
		ArrayList<Menu>myItmelist=new ArrayList<>();
		try 
		{
			statement=connection.prepareStatement(Get_FullMenuQuery);
			result=statement.executeQuery();
			while(result.next()) {

	            Menu menu = new Menu(
	                    result.getString("item_Name"),
	                    result.getDouble("item_cost"),
	                    result.getString("item_ImagePath"),
	                    result.getString("item_Description"),
	                    result.getBoolean("item_Status"),
	                    result.getDouble("item_Rating")
	            );

	            myItmelist.add(menu);
	        }
			for(Menu menus : myItmelist) {
			    System.out.println("Menu Name        : " + menus.getMenuItem_Name());
			    System.out.println("Menu Cost        : " + menus.getMenuItem_Cost());
			    System.out.println("Image Path       : " + menus.getMenuItem_ImagePath());
			    System.out.println("Description      : " + menus.getMenuItem_Description());
			    System.out.println("Status           : " + menus.isMenuItem_Status());
			    System.out.println("Rating           : " + menus.getMenuItem_Rating());
			    
			}
		
		}
		catch (SQLException |NullPointerException e) 
		{
			
			e.printStackTrace();
		}
		finally 
		{
			closeResources();	
		}		
		return myItmelist;
	}

	@Override
	public void update_MenuItem(Menu menu) {
		try {
			statement=connection.prepareStatement(Update_MenuListQuery);
			statement.setString(1,menu.getMenuItem_Name());
			statement.setDouble(2,menu.getMenuItem_Cost());
			statement.setString(3,menu.getMenuItem_ImagePath());
			statement.setString(4,menu.getMenuItem_Description());
			statement.setBoolean(5,menu.isMenuItem_Status());
			statement.setDouble(6,menu.getMenuItem_Rating());
			statement.setInt(7, menu.getMenuItem_Id());
			int row =statement.executeUpdate();
			if(row>0) 
			{
				System.out.println("Menu Update successfully.............!");
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
	public void delete_MenuItem(int menuItem_Id) {
		try {
			statement=connection.prepareStatement(Delete_MenuQuery);
			statement.setInt(1,menuItem_Id);
			int row =statement.executeUpdate();
			if(row>0)
			{
				System.out.println("!...........Menu Deleted Successfully............!");
			}
		}
		catch(SQLException e) 
		{
		
			e.printStackTrace();
		}
		finally 
		{
			closeResources();	
		}
		
	}
	
	
	
	
	
	// here we create a method to close resource that is more easy and flexible and esay to use just call in finally block 
			private void closeResources()
			{
			    try 
			    {
			        if(result != null)
			            result.close();

			        if(statement != null)
			            statement.close();

			        if(connection != null)
			            connection.close();

			    } catch(SQLException e) 
			    	{
			        e.printStackTrace();
			    	}
			}

}

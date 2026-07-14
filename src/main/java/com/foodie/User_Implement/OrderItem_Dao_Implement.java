package com.foodie.User_Implement;
import com.foodie.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;

import com.foodie.Dao.OrderitemDao;

public class OrderItem_Dao_Implement implements OrderitemDao {
	
	private Connection connection =null;
	private PreparedStatement statement=null;
	private ResultSet result = null;
	
	
	public OrderItem_Dao_Implement() {
		//here we set the username and password and url and we are set in the constructor because one time loading
				String username = "root" ;
				String password = "root";
				String url="jdbc:mysql://localhost:3306/fooddatabase";
				
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection =DriverManager.getConnection(url,username,password);
					System.out.println("!...........Connection established..........!");
				}
				catch(SQLException | ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				
				
			}
	
	
	
	//here we set all the queries of crud of the user
		final static String Add_OrderItemQuery = " INSERT INTO `orderitem_table`(`user_Id`,`menu_Id`,`item_name`,`item_Ratings`,`item_Quantity`,`item_Price`)"
											+"VALUES(?,?,?,?,?,?)";
		
		final static String Get_OrderItembyIdQuery = " SELECT * FROM `orderitem_table` WHERE `order_ItemId`=?";
		
		final static String Get_AllOrderItemQuery = " SELECT * FROM `orderitem_table`";
		
		final static String OrderItem_UpdateQuery= " UPDATE `orderitem_table` SET `user_Id`=?,`menu_Id`=?,`item_name`=?,`item_Ratings`=?,`item_Quantity`=?,`item_Price`=? Where `order_ItemId`=?";

		final static String Delete_OrderItemQuery=" DELETE FROM `orderitem_table` WHERE `order_ItemId`=? ";
		
		
	public static void main(String[] args) {
		OrderitemDao orderitemdao =new OrderItem_Dao_Implement();
		Orderitem orderitem = new Orderitem();
		
		

		/*orderitem.setOrderUserItemId(1);
		orderitem.setOrderItemMenuId(1);
		orderitem.setOrderItemName("kadai paneer");
		orderitem.setOrderItemRating(3.5);
		orderitem.setOrderItemId(3);
		orderitem.setOrderItemPrice(249);
		
		orderitemdao.addorderitem(orderitem); */ //for add ORDERitems
		
		
//		orderitemdao.getorderItem(1);// to get ORDERitem by id 
		 
		
//		orderitemdao.getallorderItem();///to get all Order details
		
		
//		to update ORDER details
		/*orderitem.setOrderUserItemId(1);
		orderitem.setOrderItemMenuId(1);
		orderitem.setOrderItemName("malai kofta");
		orderitem.setOrderItemRating(4);
		orderitem.setOrderItemId(6);
		orderitem.setOrderItemPrice(199);
		orderitem.setOrderItemId(2);
		orderitemdao.update_orderItem(orderitem);*/
		
		
		orderitemdao.delete_orderItem(2);
	}
	
	
	
	
	
	
	@Override
	public void addorderitem(Orderitem orderitem) {
		try 
		{
			statement = connection.prepareStatement(Add_OrderItemQuery);
			statement.setInt(1,orderitem.getOrderUserItemId());
			statement.setInt(2,orderitem.getOrderItemMenuId());
			statement.setString(3,orderitem.getOrderItemName());
			statement.setDouble(4,orderitem.getOrderItemRating());
			statement.setInt(5,orderitem.getOrderItemQuantity());
			statement.setDouble(6,orderitem.getOrderItemPrice());
			
			
			int row =statement.executeUpdate();
			
			
			if(row>0) 
			{
				System.out.println("Order Item Listed Successfully.......!");
			}
			else 
			{
				System.out.println("Failed to List");
			}
			
		} catch(SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			closeResources();	
		}
		
	}
	
	
	@Override
	public Orderitem getorderItem(int orderItemId) {
		Orderitem orderitemdetails=null;
		try {
			statement=connection.prepareStatement(Get_OrderItembyIdQuery);
			statement.setInt(1, orderItemId);
			result=statement.executeQuery();
			
			if(result.next()) 
			{
//				
				int OI_UserId=result.getInt("user_Id");
				int OI_menuId=result.getInt("menu_Id");
				String OI_itemName=result.getString("item_name");
				double OI_itemRating=result.getDouble("item_Ratings");
				int OI_itemQuantity=result.getInt("item_Quantity");
				double OI_itemPrice=result.getDouble("item_Price");
				
				
				
				
				/*fetch the user details from database and here we print in the console*/
			    System.out.println("OrderItemId      	: " + OI_UserId);
			    System.out.println("OrderItemMenuId         : " + OI_menuId);
			    System.out.println("OrderItemName     	: " + OI_itemName);
			    System.out.println("OrderItemRating         : " + OI_itemRating);
			    System.out.println("OrderItemQuantity       : " + OI_itemQuantity);
			    System.out.println("OrderItemPrice      	: " + OI_itemPrice);
			    
				
			    orderitemdetails = new Orderitem(OI_UserId,
			    		OI_menuId,
			    		OI_itemName,
			    		OI_itemRating,
			    		OI_itemQuantity,
			    		OI_itemPrice);
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
		return orderitemdetails;
		
	}
	@Override
	public List<Orderitem> getallorderItem() {
		ArrayList<Orderitem> OrderItemList=new ArrayList<>();
		try {
//			(`user_Id`,`menu_Id`,`item_name`,`item_Ratings`,`item_Quantity`,`item_Price`
			statement=connection.prepareStatement(Get_AllOrderItemQuery);
			result=statement.executeQuery();
			while(result.next())
			{
				int OI_Id=result.getInt("order_ItemId");
				int OI_userId=result.getInt("user_Id");
				int OI_menuId=result.getInt("menu_Id");
				String OI_itemName=result.getString("item_name");
				double OI_rating=result.getDouble("item_Ratings");
				int OI_quantity=result.getInt("item_Quantity");
				double OI_Price=result.getDouble("item_Price");
				
				
							    
			    Orderitem allOrderItem=new Orderitem(OI_Id,
			    		OI_userId,
			    		OI_menuId,
			    		OI_itemName,
			    		OI_rating,
			    		OI_quantity,
			    		OI_Price
					    );
			    OrderItemList.add(allOrderItem);
			}
			for (Orderitem Orderdata:OrderItemList) 
		    {
		    	System.out.println(Orderdata.getOrderItemId() +" | "+ Orderdata.getOrderUserItemId()+" | "+Orderdata.getOrderItemMenuId()+" | "+
		    Orderdata.getOrderItemName()+" | "+Orderdata.getOrderItemRating()+" | "+Orderdata.getOrderItemQuantity()+" | "+Orderdata.getOrderItemPrice());
		    }
			
		} catch (SQLException  e)
		{
			e.printStackTrace();
		}
		finally 
		{
			closeResources();	
		}
		
		return OrderItemList;
	}
	@Override
	public void update_orderItem(Orderitem orderitem) {
		try 
		{
//			`user_Id`,`menu_Id`,`item_name`,`item_Ratings`,`item_Quantity`,`item_Price`
			statement=connection.prepareStatement(OrderItem_UpdateQuery);
			statement.setInt(1,orderitem.getOrderUserItemId());
			statement.setInt(2,orderitem.getOrderItemMenuId());
			statement.setString(3,orderitem.getOrderItemName());
			statement.setDouble(4,orderitem.getOrderItemRating());
			statement.setInt(5,orderitem.getOrderItemQuantity());
			statement.setDouble(6,orderitem.getOrderItemPrice());
			statement.setInt(7,orderitem.getOrderItemId());
			
			int row=statement.executeUpdate();
			if (row>0) 
			{
				System.out.println("!..............Order Item Updated Successfully..............!");
			}else
			{
				System.out.println("!........Error in Update.........!");
				
			}

			
		}catch(SQLException e) 
		{
		
			e.printStackTrace();
		}
		finally 
		{
			closeResources();	
		}

		
	}
	@Override
	public void delete_orderItem(int orderItemId) {
		try {
			statement=connection.prepareStatement(Delete_OrderItemQuery);
			statement.setInt(1,orderItemId);
			int row =statement.executeUpdate();
			if(row>0)
			{
				System.out.println("!...........Order Item Deleted Successfully............!");
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

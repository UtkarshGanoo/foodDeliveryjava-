package com.foodie.User_Implement;
import com.foodie.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.foodie.Dao.*;


public class Order_Dao_Implement implements OrderDao{
	private ResultSet result;
	private Connection connection;
	private PreparedStatement statement;
	
	
	public Order_Dao_Implement() {
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
	
	
	final static String OrderAdd_Query="INSERT INTO `order_table` (`Restaurant_Id`,`user_Id`,`total_Amount`,`payment_Mode`,`order_Status`,`order_Date`,`order_Address`)"+
			"VALUES(?,?,?,?,?,?,?)";
	final static String Get_OrderbyIdQuery="SELECT * FROM `order_table` WHERE order_Id=?";

	final static String Get_FullOrderdetailsQuery="SELECT * FROM `order_table` ";

	final static String Update_OrderQuery="UPDATE `order_table` SET  `Restaurant_Id`=?,`user_Id`=?,`total_Amount`=?,`payment_Mode`=?,`order_Status`=?,`order_Date`=?, `order_Address`=? WHERE `order_Id`=?";

	final static String Delete_OrderQuery="DELETE FROM `order_table` WHERE `order_Id`=?";
	
	public static void main(String[] args) {
		OrderDao orderdao = new Order_Dao_Implement();
		Order order = new Order();
		
		
		/*order.setRestaurantId(1);
		order.setUserId(2);
		order.setTotalAmount(599);
		order.setModeOfPayment("COD");
		order.setOrderStatus("OUTFORDELIVERY");
		order.setOrderDate(LocalDateTime.now());
		order.setOrderAddress("VIAKS NAGAR NEAR RAM MANDIR");
		orderdao.addOrder(order);  //for add ORDER*/
		
		
//		orderdao.getOrder(1);// to get ORDER by id 
		 
		
//		orderdao.getallOrder();///to get all Order details
		
		
//		to update ORDER details
		/*order.setRestaurantId(1);
		order.setUserId(2);
		order.setTotalAmount(299);
		order.setModeOfPayment("UPI");
		order.setOrderStatus("CONFIRMED");
		order.setOrderDate(LocalDateTime.now());
		order.setOrderAddress("VIKAS NAGAR NEAR RAM MANDIR DEWAS 455001");
		order.setOrderId(1);
		orderdao.update_Order(order);*/
		
		
//		orderdao.delete_Order(2);
		
	}

	@Override
	public void addOrder(Order order) {
		try {
			statement = connection.prepareStatement(OrderAdd_Query);

			statement.setInt(1,order.getRestaurantId());
			statement.setInt(2,order.getUserId());
			statement.setDouble(3,order.getTotalAmount());
			statement.setString(4,order.getModeOfPayment());
			statement.setString(5,order.getOrderStatus());
			statement.setObject(6,order.getOrderDate());
			statement.setString(7, order.getOrderAddress());
			int row =statement.executeUpdate();
			
			if(row>0) 
			{
				System.out.println("Order Created Successfully.......!");
			}
			else 
			{
				System.out.println("Failed to Insert");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
	}

	@Override
	public Order getOrder(int orderId) {
		Order OrderDetail=null;
		try {
			statement=connection.prepareStatement(Get_OrderbyIdQuery);
			statement.setInt(1, orderId);
			result=statement.executeQuery();
			
			if(result.next()) 
			{
	//Restaurant_Id`=?,`user_Id`=?,`payment_Mode`=?,`order_Status`=?,`order_Date`=?, `order_Address`=? 
//				int O_OrderId = result.getInt("order_Id");
				int O_RestaurantId=result.getInt("Restaurant_Id");
				int O_orderUserId=result.getInt("user_Id");
				double O_orderTotal=result.getDouble("total_Amount");
				String O_MOP=result.getString("payment_Mode");
				String O_Status=result.getString("order_Status");
				String O_Address=result.getString("order_Address");
				LocalDateTime O_OrderDate=result.getTimestamp("order_Date").toLocalDateTime();
				
				
				
				/*fetch the user details from database and here we print in the console*/
//				 System.out.println("Order_Id      : " + O_OrderId);
			    System.out.println("Restaurant_Id      : " + O_RestaurantId);
			    System.out.println("user_Id            : " + O_orderUserId);
			    System.out.println("total_Amount       : " + O_orderTotal);
			    System.out.println("payment_Mode       : " + O_MOP);
			    System.out.println("order_Status       : " + O_Status);
			    System.out.println("order_Address      : " + O_Address);
			    System.out.println("order_Date         : " + O_OrderDate);
			   

				
				 OrderDetail = new Order(O_RestaurantId,
						 O_orderUserId,
						 O_orderTotal,
//						 O_OrderId,
						   O_MOP,
						O_Status,
						 O_OrderDate,
						 O_Address);
			}
			
		} catch (SQLException |NullPointerException  e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return OrderDetail;
	}

	@Override
	public List<Order> getallOrder() {
		ArrayList<Order> myorders = new ArrayList<Order>();
		try {
			statement=connection.prepareStatement(Get_FullOrderdetailsQuery);
			result=statement.executeQuery();
			while(result.next())
			{
				int O_RestaurantId=result.getInt("Restaurant_Id");
				int O_orderUserId=result.getInt("user_Id");
				double O_orderTotal=result.getDouble("total_Amount");
				String O_MOP=result.getString("payment_Mode");
				String O_Status=result.getString("order_Status");
				String O_Address=result.getString("order_Address");
				LocalDateTime O_OrderDate=result.getTimestamp("order_Date").toLocalDateTime();
				
				Order orderdetials = new Order(O_RestaurantId,
						 O_orderUserId,
						 O_orderTotal,
						   O_MOP,
						O_Status,
						 O_OrderDate,
						 O_Address) ;
				myorders.add(orderdetials);
			}
			for (Order Orderdata:myorders) 
		    {
		    	System.out.println(Orderdata.getRestaurantId() +" | "+ Orderdata.getUserId()+" | "+Orderdata.getTotalAmount()+" | "+
		    			Orderdata.getModeOfPayment()+" | "+Orderdata.getOrderStatus()+" | "+Orderdata.getOrderAddress()+" | "+Orderdata.getOrderDate());
		    }
			
			
			
		} catch (SQLException |NullPointerException  e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return myorders;
	}

	@Override
	public void update_Order(Order order) {
		try {
			statement = connection.prepareStatement(Update_OrderQuery);

			statement.setInt(1,order.getRestaurantId());
			statement.setInt(2,order.getUserId());
			statement.setDouble(3,order.getTotalAmount());
			statement.setString(4,order.getModeOfPayment());
			statement.setString(5,order.getOrderStatus());
			statement.setObject(6,order.getOrderDate());
			statement.setString(7, order.getOrderAddress());
			statement.setInt(8, order.getOrderId());
			int row =statement.executeUpdate();
			
			
			if(row>0) 
			{
				System.out.println("Order Updated Successfully.......!");
			}
			else 
			{
				System.out.println("Failed to Update");
			}
			
			
		} catch (SQLException |NullPointerException  e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
	}

	@Override
	public void delete_Order(int orderId) {
		try {
			statement=connection.prepareStatement(Delete_OrderQuery);
			statement.setInt(1,orderId);
			int row =statement.executeUpdate();
			if(row>0)
			{
				System.out.println("!...........Order Deleted Successfully............!");
			}
		} catch (SQLException |NullPointerException  e) {
			e.printStackTrace();
		}finally {
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

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

public class OrderHistory_Dao_Implement implements OrderHistoryDao{
	private ResultSet result;
	private Connection connection;
	private PreparedStatement statement;
	
	
	final static String orderHistoryAdd_Query="INSERT INTO `orderhistory_table` (`order_Id`,`user_Id`) VALUES(?,?)";
	
	final static String Get_orderHistoryIdQuery="SELECT * FROM `orderhistory_table` WHERE orderHistoryId=?";
	
	final static String Get_orderHistoryQuery="SELECT * FROM `orderhistory_table` ";
	
	final static String Update_orderHistoryQuery="UPDATE `orderhistory_table` SET  `order_Id`=?,`user_Id`=? WHERE `orderHistoryId`=?";
	
	final static String Delete_orderHistoryQuery="DELETE FROM `orderhistory_table` WHERE `orderHistoryId`=?";

	
	public static void main(String[] args) {
		OrderHistoryDao orderhistoryDao = new OrderHistory_Dao_Implement();
		Orderhistory orderhistory =new Orderhistory();
		
		/*orderhistory.setOrder_Id(1);
		orderhistory.setUser_Id(1);
		orderhistoryDao.addOrderHistory(orderhistory);	*/
		
//		orderhistoryDao.getOrderHistory(1);
		
//		orderhistoryDao.getAllOrderHistory();
		
		/*orderhistory.setOrder_Id(1);
		orderhistory.setUser_Id(2);
		orderhistory.setOrderHistoryId(1);
		orderhistoryDao.updateOrderHistory(orderhistory);*/
		
//		orderhistoryDao.deleteOrderHistory(1);
		
		

	}
	public OrderHistory_Dao_Implement() {
		String url = "jdbc:mysql://localHost:3306/fooddatabase";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("connection established........!");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void addOrderHistory(Orderhistory orderhistory) {
		try {
		statement=connection.prepareStatement(orderHistoryAdd_Query);
		statement.setInt(1,orderhistory.getOrder_Id());
		statement.setInt(2,orderhistory.getUser_Id());
		int row =statement.executeUpdate();
		if(row>0) 
		{
			System.out.println("orderhistory added successfully.............!");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			closeResources();
		}
	}

	@Override
	public Orderhistory getOrderHistory(int orderHistoryId) {
		Orderhistory orderHistoryList = new Orderhistory();
		try {
			statement=connection.prepareStatement(Get_orderHistoryIdQuery);
			statement.setInt(1, orderHistoryId);
			result=statement.executeQuery();
			
			
			if(result.next()) 
			{						
				/*fetch the orderhistory details from database and here we print in the console*/
			    System.out.println("orderId         : " + result.getInt("order_Id"));
			    System.out.println("UserId         	: " + result.getInt("user_Id"));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				closeResources();
			}
		return orderHistoryList;
	}

	@Override
	public List<Orderhistory> getAllOrderHistory() {
		ArrayList<Orderhistory>myorderhistorylist=new ArrayList<>();
		try {
			statement=connection.prepareStatement(Get_orderHistoryQuery);
			result=statement.executeQuery();
			
			while(result.next()) {

				Orderhistory orderhistory = new Orderhistory(result.getInt("orderHistoryId"),
	                    result.getInt("order_Id"),
	                    result.getInt("User_Id")
	                    
	                    );
				myorderhistorylist.add(orderhistory);
				
			}
			
			for(Orderhistory orderhistory : myorderhistorylist) {
			    System.out.println("orderHistoryId        : " + orderhistory.getOrderHistoryId());
			    System.out.println("orderId       	      : " + orderhistory.getOrder_Id());
			    System.out.println("userId                : " + orderhistory.getUser_Id());
			}
			
		}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				closeResources();
			}
		return myorderhistorylist;
	}

	@Override
	public void updateOrderHistory(Orderhistory orderhistory) {
		try {
			statement=connection.prepareStatement(Update_orderHistoryQuery);
			
			statement.setInt(1,orderhistory.getOrder_Id());
			statement.setInt(2,orderhistory.getUser_Id());
			statement.setInt(3,orderhistory.getOrderHistoryId());
			int row =statement.executeUpdate();
			if(row>0) 
			{
				System.out.println("orderhistory Update successfully.............!");
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				closeResources();
			}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		try {
			statement=connection.prepareStatement(Delete_orderHistoryQuery);
			statement.setInt(1,orderHistoryId);
			int row =statement.executeUpdate();
			if(row>0)
			{
				System.out.println("!...........OrderHistory Deleted Successfully............!");
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
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

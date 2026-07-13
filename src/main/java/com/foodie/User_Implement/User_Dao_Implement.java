package com.foodie.User_Implement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.foodie.Dao.*;
import com.foodie.model.*;






//here we implement the abstracts methods of User_dao interface
public class User_Dao_Implement implements User_dao{
	
	private Connection connection =null;
	private PreparedStatement statement=null;
	private ResultSet result = null;
	
	
 //here we set all the queries of crud of the user
	final static String Add_UserQuery = " INSERT INTO `userdetails`(`Name`,`Email`,`Phone`,`Address`,`Username`,`Password`,`Role`,`CreatedDate`,`LastLoginDate`)"
										+"VALUES(?,?,?,?,?,?,?,?,?)";
	
	final static String Get_UserbyIdQuery = " SELECT * FROM `userdetails` WHERE `User_Id`=?";
	
	final static String Get_AllUserQuery = " SELECT * FROM `userdetails`";
	
	final static String User_UpdateQuery= " UPDATE `userdetails` SET `Name`=?,`Email`=?,`Phone`=?,`UserName`=?,`Password`=?,`Role`=?,`Address`=? Where `User_Id`=?";

	final static String Delete_UserQuery=" DELETE FROM `userdetails` WHERE `User_Id`=? ";
	
	public User_Dao_Implement() {
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

	public static void main(String[] args) {	
/*here we create a reference of User_Dao interface	-->*/
		User_dao userDao = new User_Dao_Implement(); /*<-- here we create object of where we implement abstract methods */
		User user = new User();// we need to create separate User object 
	
		
		user.setName("Tulsidas Khan");
		user.setEmail("meerashekh@gmail.com");
		user.setPhone(9758245669L);
		user.setPassword("tK2581");
		user.setAddress("barhmangali panditchouraha near ram mandir ");
		user.setUserName("mTk1456");
		user.setRole("USER");
		user.setCreatedDateTime(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		userDao.addUser(user);  //for add user
		
		
		/*userDao.getUser(1);// to get user by id 
		 */
		
		/*userDao.getallUser();*///to get all user details
		
		
//		to update user details
		/*user.setName("Nathulal shrma");
		user.setEmail("nthu@gmail.com");
		user.setPhone(9575335089L);
		user.setUserName("nathurakhwala");
		user.setPassword("Nthu@156");
		user.setRole("User");
		user.setAddress("Vikas nagar dewas");
		user.setUser_Id(1);
		userDao.update_User(user);*/
		
		
		/*userDao.delete_User(1);*/
		
	}			

	@Override
	public void addUser(User user) {
		try 
		{
			statement = connection.prepareStatement(Add_UserQuery);

			statement.setString(1,user.getName());
			statement.setString(2,user.getEmail());
			statement.setLong(3,user.getPhone());
			statement.setString(4,user.getAddress());
			statement.setString(5,user.getUserName());
			statement.setString(6,user.getPassword());
			statement.setString(7,user.getRole());
			statement.setObject(8, user.getCreatedDateTime());
			statement.setObject(9, user.getLastLogin());
			int row =statement.executeUpdate();
			
			
			if(row>0) 
			{
				System.out.println("User Inserted Successfully.......!");
			}
			else 
			{
				System.out.println("Failed to Insert");
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
	public User getUser(int User_Id) 
	{
		User userDetail=null;
		try {
			statement=connection.prepareStatement(Get_UserbyIdQuery);
			statement.setInt(1, User_Id);
			result=statement.executeQuery();
			
			if(result.next()) 
			{
				int U_Id=result.getInt("User_Id");
				String U_Name=result.getString("Name");
				String U_Uname=result.getString("UserName");
				String U_Email=result.getString("Email");
				String U_Address=result.getString("Address");
				long U_Phone=result.getLong("Phone");
				String U_Role=result.getString("Role");
				String U_Password=result.getString("Password");
				LocalDateTime U_CreateDate=result.getTimestamp("CreatedDate").toLocalDateTime();
				LocalDateTime U_LogDate=result.getTimestamp("LastLoginDate").toLocalDateTime();
				
				
				/*fetch the user details from database and here we print in the console*/
			    System.out.println("User ID      : " + U_Id);
			    System.out.println("Name         : " + U_Name);
			    System.out.println("Username     : " + U_Uname);
			    System.out.println("Email        : " + U_Email);
			    System.out.println("Phone        : " + U_Phone);
			    System.out.println("Address      : " + U_Address);
			    System.out.println("Role         : " + U_Role);
			    System.out.println("Password     : " + U_Password);
			    System.out.println("Created Date : " + U_CreateDate);
			    System.out.println("Last Login   : " + U_LogDate);

				
				 userDetail = new User(U_Name,
					    U_Phone,
					    U_Email,
					    U_Address,
					    U_Password,
					    U_Uname,
					    U_Id,
					    U_Role,
					    U_CreateDate,
					    U_LogDate);
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
		return userDetail;
	}

	@Override
	public List<User> getallUser() {
        ArrayList<User> myuser = new ArrayList<User>();
		try {
			statement=connection.prepareStatement(Get_AllUserQuery);
			result=statement.executeQuery();
			while(result.next())
			{
				int U_Id=result.getInt("User_Id");
				String U_Name=result.getString("Name");
				String U_Uname=result.getString("UserName");
				String U_Email=result.getString("Email");
				String U_Address=result.getString("Address");
				long U_Phone=result.getLong("Phone");
				String U_Role=result.getString("Role");
				String U_Password=result.getString("Password");
				LocalDateTime U_CreateDate=result.getTimestamp("CreatedDate").toLocalDateTime();
				LocalDateTime U_LogDate=result.getTimestamp("LastLoginDate").toLocalDateTime();
				
							    
			    User allUser=new User(U_Name,
					    U_Phone,
					    U_Email,
					    U_Address,
					    U_Password,
					    U_Uname,
					    U_Id,
					    U_Role,
					    U_CreateDate,
					    U_LogDate);
			    myuser.add(allUser);
			}
			for (User Userdata:myuser) 
		    {
		    	System.out.println(Userdata.getUser_Id() +" | "+ Userdata.getName()+" | "+Userdata.getEmail()+" | "+
		    Userdata.getPhone()+" | "+Userdata.getAddress()+" | "+Userdata.getPassword()+" | "+Userdata.getRole()+" | "+
		    Userdata.getUserName()+" | "+Userdata.getCreatedDateTime()+" | "+Userdata.getLastLogin());
		    }
			
		} catch (SQLException  e)
		{
			e.printStackTrace();
		}
		finally 
		{
			closeResources();	
		}
		
		return myuser;
	}

	@Override
	public void update_User(User user) {
		try 
		{
			statement=connection.prepareStatement(User_UpdateQuery);
			statement.setString(1,user.getName());
			statement.setString(2,user.getEmail());
			statement.setLong(3,user.getPhone());
			statement.setString(4,user.getUserName());
			statement.setString(5,user.getPassword());
			statement.setString(6,user.getRole());
			statement.setString(7,user.getAddress());
			statement.setInt(8,user.getUser_Id());
			int row=statement.executeUpdate();
			if (row>0) 
			{
				System.out.println("!..............User details Updated..............!");
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
	public void delete_User(int User_Id) {
		
		try {
			statement=connection.prepareStatement(Delete_UserQuery);
			statement.setInt(1,User_Id);
			int row =statement.executeUpdate();
			if(row>0)
			{
				System.out.println("!...........User Deleted Successfully............!");
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

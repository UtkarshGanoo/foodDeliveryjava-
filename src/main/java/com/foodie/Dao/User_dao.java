package com.foodie.Dao;
import java.util.List;

import com.foodie.model.User;


// here we create an interface and 
public interface User_dao {
	void addUser(User user);
	User getUser(int User_Id);
	List<User> getallUser();
	void update_User(User user);
	void delete_User(int User_Id);
	User loginUser(String username, String password);
	
}

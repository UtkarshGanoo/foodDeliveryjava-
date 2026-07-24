package com.foodie.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodie.User_Implement.User_Dao_Implement;
import com.foodie.model.User;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setUserName(username);
		user.setPassword(password);
		user.setRole("User");//default user type 
	    user.setAddress(" ");
	    
	    
	    user.setCreatedDateTime(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        
        User_Dao_Implement userDao = new User_Dao_Implement();
        userDao.addUser(user);
        resp.sendRedirect("Login.jsp");
		
	}
}

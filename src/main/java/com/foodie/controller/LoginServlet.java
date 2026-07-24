package com.foodie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodie.User_Implement.User_Dao_Implement;
import com.foodie.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User_Dao_Implement userDao = new User_Dao_Implement();
		
		User user = userDao.loginUser(username,password);
		
		if(user != null) {

            HttpSession session = request.getSession();

            session.setAttribute("loggedInUser", user);

            response.sendRedirect("RestaurantServlet");

        }
        else {

        	request.setAttribute("error",
                    "Invalid Username or Password");

        	request.getRequestDispatcher("Login.jsp")
               .forward(request, response);
        }
		
	}

}

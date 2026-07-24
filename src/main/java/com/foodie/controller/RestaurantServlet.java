package com.foodie.controller;
import com.foodie.User_Implement.*;
import com.foodie.model.Restaurant;
import com.foodie.Dao.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		HttpSession session = request.getSession(false);

	        if (session == null || session.getAttribute("loggedInUser") == null) {
	            response.sendRedirect("Login.jsp");
	            return;
	        }
	        
	        //here we fetch restaurants 
		Restaurant_Dao_Implement RdaoI = new Restaurant_Dao_Implement();
	        List<Restaurant> restaurantList = RdaoI.getallRestaurant();
	        request.setAttribute("restaurantList", restaurantList);
	        request.getRequestDispatcher("/RestaurentCard.jsp")
	                .forward(request, response);
		
		
	}


}

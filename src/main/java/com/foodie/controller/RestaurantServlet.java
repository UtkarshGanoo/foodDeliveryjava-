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

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Restaurant_Dao_Implement RdaoI = new Restaurant_Dao_Implement();

	        // call getallRestaurant() using the reference
	        List<Restaurant> restaurantList = RdaoI.getallRestaurant();


	        // put the list in session object
	        HttpSession session = request.getSession();
	        session.setAttribute("restaurantList", restaurantList);

	        // forward to jsp (jsp will read it from session)
	        request.getRequestDispatcher("/RestaurentCard.jsp")
	                .forward(request, response);
		
		
	}


}

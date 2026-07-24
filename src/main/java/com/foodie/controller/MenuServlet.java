package com.foodie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodie.User_Implement.Menu_Dao_Implement;
import com.foodie.model.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int restaurantId =
                Integer.parseInt(request.getParameter("restaurantId"));
//        System.out.println("Restaurant Id = " + restaurantId);

        Menu_Dao_Implement dao = new Menu_Dao_Implement();

        List<Menu> menuList =dao.getMenuByRestaurantId(restaurantId);
//        System.out.println(menuList);

        request.setAttribute("menuList", menuList);

        request.getRequestDispatcher("Menu.jsp")
               .forward(request, response);
	}

}

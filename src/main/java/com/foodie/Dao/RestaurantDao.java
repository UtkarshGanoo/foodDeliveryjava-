package com.foodie.Dao;
import java.util.List;
import com.foodie.model.*;

public interface RestaurantDao {
	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int Restaurant_Id);
	List<Restaurant> getallRestaurant();
	void update_Restaurant(Restaurant restaurant);
	void delete_Restaurant(int Restaurant_Id);
}

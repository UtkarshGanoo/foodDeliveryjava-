package com.foodie.Dao;
import java.util.List;

import com.foodie.model.*;

public interface MenuDao {
	void addMenuItem(Menu menu);
	Menu getMenuItem(int menuItem_Id);
	List<Menu> getallMenuItem();
	List<Menu> getMenuByRestaurantId(int restaurantId);
	void update_MenuItem(Menu menu);
	void delete_MenuItem(int menuItem_Id);

}

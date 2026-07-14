package com.foodie.Dao;

import java.util.List;
import com.foodie.model.Orderitem;

public interface OrderitemDao {
	void addorderitem(Orderitem orderitem);
	Orderitem getorderItem(int orderItemId);
	List<Orderitem> getallorderItem();
	void update_orderItem(Orderitem orderitem);
	void delete_orderItem(int orderItemId);
	
}

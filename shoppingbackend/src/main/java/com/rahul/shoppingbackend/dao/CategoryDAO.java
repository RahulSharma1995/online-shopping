package com.rahul.shoppingbackend.dao;

import java.util.List;

import com.rahul.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}

package com.rahul.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rahul.shoppingbackend.dao.CategoryDAO;
import com.rahul.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static
	{
		Category category=new Category();
		
		// adding 1st Category
		category.setId(1);
		category.setName("Television");
		category.setDiscription("This is some discription for Television!");
		category.setImageUrl("");
		
		categories.add(category);
		
		// 2nd category
		category=new Category();
	
		category.setId(2);
		category.setName("Mobile");
		category.setDiscription("This is some discription for Mobile!");
		category.setImageUrl("");
		categories.add(category);
		
		// 3rd category
		category=new Category();
			
		category.setId(3);
		category.setName("Laptop");
		category.setDiscription("This is some discription for Laptop!");
		category.setImageUrl("");
		categories.add(category);
		
	}
	
	

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}



	@Override
	public Category get(int id) {
		// enchanced for loop
		
		for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}
		
		
		return null;
	}

}

package com.rahul.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.shoppingbackend.dao.CategoryDAO;
import com.rahul.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
		
	}
/*	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		category.setName("Television");
		category.setDiscription("This is some discription for Television!");
		category.setImageUrl("CAT_105.png");
		
		assertEquals("Something went wrong while inserting a new category!",true,categoryDAO.add(category));
	}
*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(3);
		assertEquals("Something went wrong while fetching the single category!","Television",category.getName());
		
	}*/
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Something went wrong while updating the existing Record!",true,categoryDAO.update(category));
		
	}*/
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(3);
		assertEquals("Something went wrong while deleting the existing Record!",true,categoryDAO.delete(category));
		
	}*/
	
	/*@Test
	public void testListCategory() {
		assertEquals("Something went wrong while fetching the list of category!",2,categoryDAO.list().size());
		
	}*/
	
	@Test
	public void testCURDCategory() {
		
		
		// adding operation
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some discription for Television!");
		category.setImageUrl("CAT_1.png");
		
		assertEquals("Something went wrong while inserting a new category!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is some discription for Mobile!");
		category.setImageUrl("CAT_2.png");
		
		assertEquals("Something went wrong while inserting a new category!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some discription for Laptop!");
		category.setImageUrl("CAT_3.png");
		
		assertEquals("Something went wrong while inserting a new category!",true,categoryDAO.add(category));

		// Fetching and updating Operation
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Something went wrong while updating the existing Record!",true,categoryDAO.update(category));
		
		//Deleting operation
		assertEquals("Something went wrong while deleting the existing Record!",true,categoryDAO.delete(category));
		
		//Fetching the list of the Category
		assertEquals("Something went wrong while fetching the list of category!",2,categoryDAO.list().size());


	}
	
}

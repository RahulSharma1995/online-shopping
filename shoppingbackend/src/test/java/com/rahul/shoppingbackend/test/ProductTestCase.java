package com.rahul.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rahul.shoppingbackend.dao.ProductDAO;
import com.rahul.shoppingbackend.dto.Product;

public class ProductTestCase {
private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rahul.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
		
	}
	
	/*@Test
	public void testCURDCategory() {
	
		// create operation
		product = new Product();
		product.setName("Oppo Selfi Expert F3");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product!"
						,true,productDAO
							.add(product));
	
		//reading and updating the product
		product = productDAO.get(2);
		product.setName("Sumsung Galaxy S7");
		
		assertEquals("Something went wrong while updating the existing Record!"
				,true,productDAO
					.update(product));
		
		//deleting the product
		
		assertEquals("Something went wrong while updating the existing Record!"
				,true,productDAO
					.delete(product));
		
		// List of Products
		
		assertEquals("Something went wrong while updating the existing Record!"
				,6,productDAO
					.list().size());
	}*/
	
	@Test
	public void testListActiveProducts() {
		
		assertEquals("Something went wrong while updating the existing Record!"
				,5,productDAO
					.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while updating the existing Record!"
				,3,productDAO
					.listActiveProductsByCategory(3).size());
		
		assertEquals("Something went wrong while updating the existing Record!"
				,2,productDAO
					.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testGetActiveProductsByCategory() {
		assertEquals("Something went wrong while updating the existing Record!"
				,3,productDAO
					.getLatestActiveProducts(3).size());
		
	}
}

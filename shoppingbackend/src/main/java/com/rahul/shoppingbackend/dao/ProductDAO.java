package com.rahul.shoppingbackend.dao;

import java.util.List;

import com.rahul.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int id);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	//business method
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int category);
	List<Product> getLatestActiveProducts(int count);
}

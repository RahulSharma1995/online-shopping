package com.rahul.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rahul.shoppingbackend.dao.ProductDAO;
import com.rahul.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProduct(){
		
		return productDAO.listActiveProducts();
		
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
		
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductForAdmin(){
		
		return productDAO.list();
		
	}
	
	
	
}

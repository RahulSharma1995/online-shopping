package com.rahul.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.onlineshopping.exception.ProductNotFoundException;
import com.rahul.shoppingbackend.dao.CategoryDAO;
import com.rahul.shoppingbackend.dao.ProductDAO;
import com.rahul.shoppingbackend.dto.Category;
import com.rahul.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Insede PageController index method - INFO");
		logger.debug("Insede PageController index method - DEBUG");
		
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDAO.list());
		
		return mv;
	}
	
	@RequestMapping(value= "about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		
		return mv;
	}
	
	@RequestMapping(value= "contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		return mv;
	}
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDAO.list());
		
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category=null;
		category=categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickCategoryProducts", true);
		//PASSING A SINGLE CATEGORY OBJECT
		mv.addObject("category", category);
		
		return mv;
	}
	
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)  throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		//update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
		
		mv.addObject("title",product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	

}

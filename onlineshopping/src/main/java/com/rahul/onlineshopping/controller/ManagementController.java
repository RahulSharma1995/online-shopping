package com.rahul.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.onlineshopping.util.FileUploadUtility;
import com.rahul.onlineshopping.validator.ProductValidator;
import com.rahul.shoppingbackend.dao.CategoryDAO;
import com.rahul.shoppingbackend.dao.ProductDAO;
import com.rahul.shoppingbackend.dto.Category;
import com.rahul.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation",required=false) String operation ) {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product nProduct = new Product();
		
		//set some fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Product");
		
		if(operation!=null)
		{
			if(operation.equals("product")){
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		//fetch the product from the database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		//activating and deactivating based on the value of isActive field
		product.setActive(!product.isActive());
		//update the product 
		productDAO.update(product);
		
		return (isActive)? 
				"You have succesfully deactvated the product with id "+product.getId() 
				: "You have succesfully actvated the product with id "+product.getId();
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id ) {
		
		ModelAndView mv = new ModelAndView("page");
		//fetch product from the data base
		Product nProduct =productDAO.get(id);
		//set the product fetch from database
		mv.addObject("product",nProduct);
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Product");
		
		return mv;
	}
	
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		if(mProduct.getId()==0)
		{
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Product");
			model.addAttribute("message", "Validation faild for Product Submission!");
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		if(mProduct.getId()==0)
		{
			//create a new product if the id is 0
			productDAO.add(mProduct);
		}
		else
		{
			//update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute("category") Category category)
	{
		//add new Category
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	
	//returning all the categories
		@ModelAttribute("categories")
		public List<Category> getCategories(){
			return categoryDAO.list();
		}
		
		@ModelAttribute("category")
		public Category getCategory() {
			
			return new Category();
		}
	
}

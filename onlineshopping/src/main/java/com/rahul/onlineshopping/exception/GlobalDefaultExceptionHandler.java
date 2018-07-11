package com.rahul.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "the page is not constructed!");
		mv.addObject("errorDescription", "The page yur are lokking for is not available now!");
		mv.addObject("title","404 error page");
		
		
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available!");
		mv.addObject("errorDescription", "The product  yur are lokking for is not available right now!");
		mv.addObject("title","Product unavailable");
		
		
		return mv;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		
		//only for debugging purpose
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorTitle", "Contact Your Administrator!!");
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title","Error");
		
		
		return mv;
	}

}

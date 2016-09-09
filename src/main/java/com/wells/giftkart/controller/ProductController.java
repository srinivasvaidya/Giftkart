package com.wells.giftkart.controller;

import java.util.List;

import javax.persistence.Version;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.service.IProductService;
import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;


@Controller
@RequestMapping(value="/products")
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	IProductService productService;
	
	@ExceptionHandler(GiftkartPersistenceException.class)
	public ModelAndView handleCustomException()
	{
		logger.info(" handleCustomException() started ");
		ModelAndView model=new ModelAndView("error");
		logger.info(" handleCustomException() end ");
		return model;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ModelAndView getAllProducts(HttpServletRequest request) throws GiftkartPersistenceException 
	{
		logger.info(" getAllProducts() started "); 
		ModelAndView welcomeview=new ModelAndView("products");
		
		List<Product> productlist=productService.getProductList();
		request.getSession().setAttribute("productlist", productlist);
		welcomeview.addObject("productlist", productlist);
		logger.info(" getAllProducts() end "); 
		return welcomeview;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addProduct(HttpServletRequest request) throws GiftkartPersistenceException 
	{
		logger.info(" addProduct() started "); 
		ModelAndView productview=new ModelAndView("addproduct");
		
		List<ProductCategory> categoryList= productService.getCategoriesList_hibernate();
		request.getSession().setAttribute("categoryList", categoryList);
		productview.addObject(categoryList);
		logger.info(" addProduct() end "); 
		return productview;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addProduct_post(@ModelAttribute("product") Product productVO,HttpServletRequest request,BindingResult bindingResult) throws GiftkartPersistenceException 
	{
		logger.info(" addProduct_post() started "); 
		logger.debug("  "+ productVO.getProdname());
		logger.debug("  "+ productVO.getColour());
		logger.debug("  "+ productVO.getPrice());
		//logger.debug("  "+ product.getCategory().getCategoryid());
		
		ModelAndView productview=new ModelAndView("adminsuccess");
		if(bindingResult.hasErrors())
		{
			logger.info(" binding is failed ");
			return new ModelAndView("adminerror");
		}
		List<ProductCategory> categoryList=(List<ProductCategory>) request.getSession().getAttribute("categoryList");
		
		for(ProductCategory cat: categoryList)
		{
			if(cat.getCatagoryname().equals(productVO.getCategory().getCatagoryname()))
			{
				productVO.getCategory().setCategoryid(cat.getCategoryid());
				break;
			}
		}
		//product.setCategory();;
		productService.addProduct_hibernate(productVO);
		
		logger.info(" addProduct_post() end "); 
		return productview;
	}
	}

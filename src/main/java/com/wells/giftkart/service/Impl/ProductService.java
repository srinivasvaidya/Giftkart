package com.wells.giftkart.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wells.giftkart.controller.ProductController;
import com.wells.giftkart.dao.IProductDao;
import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.manager.IManager;
import com.wells.giftkart.manager.IProductManager;
import com.wells.giftkart.service.IProductService;
import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;

@Service
public class ProductService implements IProductService{
	
	private static final Logger logger = Logger.getLogger(ProductService.class);
	
	@Autowired
	IProductDao productDao;
	
	@Autowired
	private IProductManager productManager;

	@Autowired
	private IManager	mqManager;
	
	/*@Autowired
	private MQClient	 mqClient;
	*/
	

	/*public MQClient getMqClient() {
		return mqClient;
	}

	public void setMqClient(MQClient mqClient) {
		this.mqClient = mqClient;
	}*/

	public IProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(IProductManager productManager) {
		this.productManager = productManager;
	}

	public IManager getMqManager() {
		return mqManager;
	}

	public void setMqManager(IManager mqManager) {
		this.mqManager = mqManager;
	}

	public static List<Product> prodlist=new ArrayList<Product>();
	public static Map<Long ,Product> prodMap=new HashMap<Long,Product>();
	
	 static {
		ProductCategory prodcategory1=new ProductCategory();
		prodcategory1.setCatagoryname("Apparel");
		prodcategory1.setCategoryid(1);
		
		ProductCategory prodcategory2=new ProductCategory();
		prodcategory2.setCatagoryname("Bags");
		prodcategory2.setCategoryid(2);
		
		ProductCategory prodcategory3=new ProductCategory();
		prodcategory3.setCatagoryname("Watches");
		prodcategory3.setCategoryid(3);
		
		Product prod1=new Product();
		prod1.setProductId(101);
		prod1.setProdname("t-shirt");
		prod1.setPrice(700.00);
		prod1.setColour("blue");
		prod1.setCategory(prodcategory1);
		
		Product prod2=new Product();
		prod2.setProductId(201);
		prod2.setProdname("fasttrack bag");
		prod2.setPrice(2000.00);
		prod2.setColour("red");
		prod2.setCategory(prodcategory2);
		
		Product prod3=new Product();
		prod3.setProductId(301);
		prod3.setProdname("timex watch");
		prod3.setPrice(5000.00);
		prod3.setColour("black");
		prod3.setCategory(prodcategory3);
		
		prodlist.add(prod1);
		prodlist.add(prod2);
		prodlist.add(prod3);	
		
		prodMap.put(prod1.getProductId(), prod1);
		prodMap.put(prod2.getProductId(), prod2);
		prodMap.put(prod3.getProductId(), prod3);
		
	}
	 public boolean addProduct(Product prod)
	 {
		 
		 return true;
	 }
	public List<Product> getProductList() throws GiftkartPersistenceException
	{		
		System.out.println("in getProductList()");
		//sendProductstoMQ();
		//getProductsfromMQ();
		
		return productDao.getProductList();
	}
	
	public Product getProductwithID(long id)	
	{
		System.out.println("in getProductwithID()");
		return prodMap.get(id);
	}
	
	public Product getProductsfromVendor()
	{
		System.out.println("in getProductsfromVendor() ");
		Product p1=productManager.getProductsfromVendor();
		return p1;
	}
	
	public boolean sendProductstoMQ()
	{
		System.out.println(" in sendProductstoMQ()");
		System.out.println(mqManager);
		mqManager.sendMessage();
		return true;
	}
	
	public boolean getProductsfromMQ()
	{
		System.out.println(" in getProductstoMQ()");
		mqManager.recieveMessage();
		//mqClient.recieveMessage();
		return true;
	}
	
	public void addProduct_hibernate(Product productVO){
		logger.info("addProduct_hibernate() started");
		
		productDao.addProduct_hibernate(productVO);
		
		logger.info("addProduct_hibernate() end");
	}
	
	public ProductCategory getCategorywithID_hibernate(long categoryId){
		logger.info("getCategorywithID_hibernate() started");
		
		logger.info("getCategorywithID_hibernate() end");
		return productDao.getCategorywithID_hibernate(categoryId);
		
	}
	
	public List<ProductCategory> getCategoriesList_hibernate(){
		logger.info("getCategoriesList_hibernate() started");
		
		logger.info("getCategoriesList_hibernate() end");
		return productDao.getCategoriesList_hibernate();
	}
}

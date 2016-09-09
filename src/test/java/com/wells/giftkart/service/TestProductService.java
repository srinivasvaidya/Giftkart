package com.wells.giftkart.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.service.Impl.ProductService;
import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:GiftKart/src/main/webapp/WEB-INF/spring-mvc-servlet.xml","spring/spring-core.xml", "spring/spring-jdbc.xml" })
@ContextConfiguration(locations={"classpath:spring/spring-core.xml", "classpath:spring/spring-jdbc.xml","classpath:hibernate/hibernate.cfg.xml" })
public class TestProductService {

	//@Test
	public void testgetProductList() {
		
		List<Product> prodlist=new ArrayList<Product>();
		ProductService ps=new ProductService();
		try {
			prodlist=ps.getProductList();
		} catch (GiftkartPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3L, prodlist.size());
		//fail("Not yet implemented");
	}
	
	//@Test
	public void testgetProductwithID() {
		
		Product prod=new Product();
		ProductService ps=new ProductService();
		prod=ps.getProductwithID(101L);
		assertTrue("prod name is t-shirt ", prod.getProdname().equalsIgnoreCase("t-shirt"));
		//fail("Not yet implemented");
	}
@Test
@Ignore
	public void tesgetCategoriesList_hibernate()
	{
		ProductService ps=new ProductService();
		List<ProductCategory> catList=ps.getCategoriesList_hibernate();
		assertNotNull(catList);
	}

}

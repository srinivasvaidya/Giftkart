package com.wells.giftkart.manager;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.wells.giftkart.valueobject.Product;

public class ProductManager implements IProductManager  {

	public Product getProductsfromVendor()
	{
		System.out.println("getProductsfromVendor() ");
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:8080/GiftKart_Webservices/rest/products/all");
		Builder builder=target.request(MediaType.APPLICATION_XML);
		Product p1=builder.get(Product.class);
		System.out.println(" exiting getProductsfromVendor() ");
		System.out.println(p1.getProductId() + " "+ p1.getProdname());
		return p1;		
	}
}
 
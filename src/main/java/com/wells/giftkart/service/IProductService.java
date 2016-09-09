/**
 * 
 */
package com.wells.giftkart.service;

import java.util.List;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;

/**
 * @author u268407
 *
 */
public interface IProductService {

	public List<Product> getProductList() throws GiftkartPersistenceException;
	
	public boolean addProduct(Product prod);
	
	public Product getProductwithID(long id);
	
	public Product getProductsfromVendor();
	
	public boolean sendProductstoMQ();
	
	public boolean getProductsfromMQ();
	
	public void addProduct_hibernate(Product productVO);
	
	public ProductCategory getCategorywithID_hibernate(long categoryId);
	
	public List<ProductCategory> getCategoriesList_hibernate();
	
}

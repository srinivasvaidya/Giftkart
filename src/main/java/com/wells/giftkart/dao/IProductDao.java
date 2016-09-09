package com.wells.giftkart.dao;

import java.util.List;

import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;

public interface IProductDao {

	public Product getProductwithID(long prodId);
	
	public List<Product> getProductList() throws GiftkartPersistenceException;
	
	public void addProduct_hibernate(Product productVO);
	
	public ProductCategory getCategorywithID_hibernate(long categoryId);
	
	public List<ProductCategory> getCategoriesList_hibernate();
}

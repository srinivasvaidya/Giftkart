package com.wells.giftkart.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.wells.giftkart.dao.IProductDao;
import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.util.HibernateUtil;
import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;


public class ProductDaoImpl extends BaseDaoImpl implements IProductDao{

	public static final  Logger logger=Logger.getLogger(ProductDaoImpl.class);
	
	public List<Product> getProductList() throws GiftkartPersistenceException
	{
		logger.info(" getProductList() started ");  
		String sql= "select * from t_gk_products products, t_gk_product_category category where products.categoryid=category.categoryid ";
		logger.debug("  getProductList() sql : "+sql); 
		
		final List<Product> prodList=new ArrayList<Product>();
		 
		final RowMapper<List<Product>> mapper=new RowMapper<List<Product>>() {
			@Override
			public List<Product> mapRow(ResultSet rs, int rowNum) throws SQLException {
				prodList.add(fillVOforgetProductDetails(rs));
				return prodList;
			}
		};
		
		getJdbcTemplate().query(sql, mapper);

		logger.info(" getProductList() end ");  
		return prodList;
		
	}
	
	private Product fillVOforgetProductDetails(ResultSet rs) throws SQLException{
		logger.info(" fillVOforgetProductDetails() started ");  
		Product productVO= null;
	if(rs!=null)
	{
		logger.info(" result set is not null ");  
		productVO=new Product();
		productVO.setProductId(rs.getLong("productId"));
		productVO.setProdname(rs.getString("prodname"));
		productVO.setPrice(rs.getDouble("price"));
		productVO.setColour(rs.getString("colour"));
		
		ProductCategory categoryVO=new ProductCategory();
		categoryVO.setCategoryid(rs.getLong("categoryid"));
		categoryVO.setCatagoryname(rs.getString("catagoryname"));
		
		productVO.setCategory(categoryVO);
		
	}
	logger.info(" fillVOforgetProductDetails() end ");  
	return productVO;
	}

	@Override
	public Product getProductwithID(long prodId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addProduct_hibernate(Product productVO) 
	{
		logger.info(" addProduct_hibernate() started ");  
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(productVO);
		session.getTransaction().commit();
		session.close();
		logger.info(" addProduct_hibernate() end ");  
	}
	
	@Override
	public ProductCategory getCategorywithID_hibernate(long categoryId) {
		// TODO Auto-generated method stub
		logger.info(" getCategorywithID_hibernate() started ");  
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ProductCategory category=(ProductCategory)session.get(ProductCategory.class, categoryId);
		session.close();

		logger.info(" getCategorywithID_hibernate() end ");  
		
		return category;
	}
	
@Override
	public List<ProductCategory> getCategoriesList_hibernate() {
		// TODO Auto-generated method stub
	logger.info(" getCategoriesList_hibernate() started ");  
	//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	Session session=HibernateUtil.getSessionFactory().openSession();
	//Session session=sessionFactory.openSession(); 
	session.beginTransaction();
	Query query=session.createQuery("from ProductCategory");
	
	logger.debug(" query is "+ query.toString());  
	List<ProductCategory> categoryList=query.list();
	
	logger.debug(" categoryList size "+ categoryList.size()); 
	session.close();

	logger.info(" getCategoriesList_hibernate() end ");  
	
	return categoryList;
	}
}

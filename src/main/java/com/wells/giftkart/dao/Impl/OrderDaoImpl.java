package com.wells.giftkart.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.wells.giftkart.dao.IOrderDao;
import com.wells.giftkart.exceptions.GiftkartPersistenceException;
import com.wells.giftkart.valueobject.Order;
import com.wells.giftkart.valueobject.ProductOrder;

public class OrderDaoImpl 	extends BaseDaoImpl implements IOrderDao {
	public static final Logger logger = Logger.getLogger(OrderDaoImpl.class);

	@Override
	public Long saveOrder(Long userid) throws GiftkartPersistenceException {
		logger.info(" saveOrder() started ");

		final String orderIdQuery = "values ( next value for orderid_seq)";
		long orderid;
		try {
			//long orderid = getJdbcTemplate().query(orderIdQuery, rowMapper);// ForObject(orderIdQuery, Class<Long>);// (orderIdQuery, Class Long);
			//long orderid = 101L;
			 orderid = getJdbcTemplate().queryForObject(orderIdQuery, Long.class);
			
			logger.debug(" order id is : " + orderid);
		} catch (DataAccessException DAex) {
			logger.debug("error msg is : " + DAex);
			throw new GiftkartPersistenceException();
		}
		
		String sql = "insert into t_gk_orders values(?,?,current_date,?,?)";
		logger.debug(" saveOrder() sql : " + sql);
		String status = "CREATED";

		Object[] values = new Object[4];
		int index = 0;
		values[index++] = orderid;
		values[index++] = status;
		values[index++] = null;
		values[index++] = userid;

		try {
			 getJdbcTemplate().update(sql, values);

			logger.debug(" order id is : " + orderid);
		} catch (DataAccessException DAex) {
			logger.debug("error msg is : " + DAex);
			throw new GiftkartPersistenceException();
		}

		logger.info(" saveOrder() end ");
		return orderid;
	}

	@Override
	public void saveProductOrder(Long orderid, List<Long> kartProdIds)
			throws GiftkartPersistenceException {
		logger.info(" saveProductOrder() started ");
		String sql = "insert into t_gk_product_order values(?,next value for product_orderid_seq,?,current_date,?,?)";
		logger.debug(" saveOrder() sql : " + sql);
		String status = "CREATED";

		for (Long prodId : kartProdIds) {
			Object[] values = new Object[4];
			int index = 0;
			values[index++] = orderid;
			values[index++] = status;
			values[index++] = null;
			values[index++] = prodId;

			try {
				getJdbcTemplate().update(sql, values);
				logger.debug(" product order is saved ");
			} catch (DataAccessException DAex) {
				logger.debug("error msg is : " + DAex);
				throw new GiftkartPersistenceException();
			}
		}
		logger.info(" saveProductOrder() end ");
	}

	@Override
	public Order getOrder(Long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Order> getAllOrders(Long userid) {
		// TODO Auto-generated method stub
		logger.info("get all orders() starteed");

		String sql = "select * from t_gk_orders where userid=? ";
		logger.debug(" saveOrder() sql : " + sql);

		Object[] values = new Object[1];
		int index = 0;
		values[index++] = userid;

		final List<Order> orderList = new ArrayList<Order>();

		final RowMapper<List<Order>> mapper = new RowMapper<List<Order>>() {
			@Override
			public List<Order> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				orderList.add(fillVOforgetAllOrders(rs));
				return orderList;
			}

			private Order fillVOforgetAllOrders(ResultSet rs)
					throws SQLException {
				// TODO Auto-generated method stub
				logger.info(" fillVOforgetAllOrders() started ");
				Order orderVO = null;
				if (rs != null) {
					logger.info(" result set is not null ");
					orderVO = new Order();
					orderVO.setOrderId(rs.getLong("orderId"));
					orderVO.setOrderStatus(rs.getString("orderStatus"));
					orderVO.setUserid(rs.getLong("userid"));
				}
				logger.info(" fillVOforgetAllOrders() end ");
				return orderVO;
			}
		};

		getJdbcTemplate().query(sql, mapper, values);

		logger.info("get all orders() end");
		return orderList;
	}

	public List<Order> getAllOrders2(Long userid) {
		// TODO Auto-generated method stub
		logger.info("get all orders() starteed");

		String sql = "select orders.userid, orders.orderid, orders.orderStatus, orders.orderDate,  prodorder.productorderid, prodorder.productid, prodorder.orderDate , prodorder.orderStatus";
				sql+="  from t_gk_orders orders inner join t_gk_product_order prodorder on orders.orderid= prodorder.orderid and orders.userid=? ";
		logger.debug(" saveOrder() sql : " + sql);

		Object[] values = new Object[1];
		int index = 0;
		values[index++] = userid;
		final Set<Order> orderSet=new HashSet<Order>();
		
		final RowMapper<ProductOrder> mapper = new RowMapper<ProductOrder>() {
			@Override
			public ProductOrder mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Map<Order, ProductOrder> orderMap=new HashMap<Order,ProductOrder>();
				orderMap=fillVOforgetAllOrders(rs);
				Order order=new Order();
				logger.info("in maprow() method ");
				for(Order orderVO: orderMap.keySet())
				{
					order=orderVO;
					orderSet.add(orderVO);
				}
				
				return orderMap.get(order);
			}

			private Map<Order, ProductOrder> fillVOforgetAllOrders(ResultSet rs)
					throws SQLException {
				// TODO Auto-generated method stub
				logger.info(" fillVOforgetAllOrders() started ");	
				ProductOrder prodorderVO = null;
				Order orderVO = null;
				Map<Order, ProductOrder> orderMap=new HashMap<Order,ProductOrder>();
				
				if (rs != null) {
					logger.info(" result set is not null ");
					orderVO = new Order();
					orderVO.setOrderId(rs.getLong("orderId"));
					orderVO.setUserid(rs.getLong("userid"));
					orderVO.setOrderStatus(rs.getString("orderstatus"));
					orderVO.setOrderDate(rs.getDate("orderDate"));

					prodorderVO = new ProductOrder();
					prodorderVO.setOrderId(rs.getLong("orderId"));
					prodorderVO.setProdorderStatus(rs.getString("orderStatus"));
					prodorderVO.setProductorderId(rs.getLong("productorderId"));
					prodorderVO.setProductid(rs.getLong("productid"));
					prodorderVO.setOrderDate(rs.getDate("orderDate"));
					prodorderVO.setOrderId(rs.getLong("orderId"));
					
					orderMap.put(orderVO, prodorderVO);
					
					if(orderMap.containsKey(orderVO))
					{
						logger.info("in if block ");
						//(orderMap.get(orderVO)).add(prodorderVO);	
					}
					else 
					{
						logger.info("in else block ");
						List<ProductOrder> prodorderlist=new ArrayList<ProductOrder>();
						prodorderlist.add(prodorderVO);
						//orderMap.put(orderVO, prodorderlist);
					}
					for(Order order: orderMap.keySet())
					{
						logger.info("in for loop ");
						//order.setProductOrders(orderMap.get(order));
					}
					
					logger.debug(" order map size  "+ orderMap.size());
				}
				logger.info(" fillVOforgetAllOrders() end ");
				return orderMap;
			}
		};

		List<ProductOrder> orderList= getJdbcTemplate().query(sql, mapper, values);

		logger.info("orderset size is "+ orderSet.size());
		
		List<Order> orders=new ArrayList<Order>();
		for(Order order: orderSet)
		{
			logger.info("in outer for loop ");
			List<ProductOrder> prodorders=new ArrayList<ProductOrder>();
			for(ProductOrder prodOrder: orderList)
			{
				logger.info("in inner for loop ");
				if(order.getOrderId()==prodOrder.getOrderId())
				{
					prodorders.add(prodOrder);
				}
			}
			order.setProductOrders(prodorders);
			orders.add(order);
		}
	
		logger.info("get all orders() end");
		return orders;
	}
	
	@Override
	public List<ProductOrder> getAllProdOrders(Long orderid) {
		// TODO Auto-generated method stub
		logger.info("get all orders() starteed");

		// String
		// sql="select prodorder.productorderid, orders.orderid, prodorder.productid from t_gk_orders orders inner join t_gk_product_order prodorder on orders.orderid= prodorder.orderid and orders.orderid=? ";
		String sql = "select * from t_gk_product_order  where orderid=? ";
		logger.debug(" saveOrder() sql : " + sql);

		Object[] values = new Object[1];
		int index = 0;
		values[index++] = orderid;

		final List<ProductOrder> prodorderList = new ArrayList<ProductOrder>();

		final RowMapper<List<ProductOrder>> mapper = new RowMapper<List<ProductOrder>>() {
			@Override
			public List<ProductOrder> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				prodorderList.add(fillVOforgetAllProdOrders(rs));
				return prodorderList;
			}

			private ProductOrder fillVOforgetAllProdOrders(ResultSet rs)
					throws SQLException {
				// TODO Auto-generated method stub
				logger.info(" fillVOforgetAllProdOrders() started ");
				ProductOrder prodorderVO = null;
				if (rs != null) {
					logger.info(" result set is not null ");
					prodorderVO = new ProductOrder();
					prodorderVO.setOrderId(rs.getLong("orderId"));
					prodorderVO.setProductorderId(rs.getLong("productorderId"));
					prodorderVO.setProductid(rs.getLong("productid"));
					prodorderVO.setProdorderStatus(rs.getString("orderStatus"));
					prodorderVO.setOrderDate(rs.getDate("orderDate"));
					prodorderVO.setModifiedDate(rs.getDate("modifiedDate"));
				}
				logger.info(" fillVOforgetAllProdOrders() end ");
				return prodorderVO;
			}
		};

		getJdbcTemplate().query(sql, mapper, values);

		logger.info("get all orders() end");
		return prodorderList;
	}

	
	@Override
	public boolean updateOrder(Long orderid) {
		// TODO Auto-generated method stub
		return false;
	}

}

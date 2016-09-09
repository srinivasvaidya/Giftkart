package com.wells.giftkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDatabase {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection conn=DriverManager.getConnection("jdbc:derby://localhost/C:/Users/u268407/C3P_Workspace/c3p/Softwares/db-derby-10.12.1.1-bin/giftkart_db1;user=derby;password=secret");
		PreparedStatement stat=conn.prepareStatement("select * from t_gk_users");
		ResultSet rs=stat.executeQuery();
		System.out.println("connection established");
		while(rs.next())
		{
			System.out.println(rs.getRow());
			System.out.println(rs.getFetchSize());
			System.out.println(rs.getString(1));
			System.out.println(rs.getInt(2));
		}
		
		stat.close();
		conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("exception1");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("exception2");
			e.printStackTrace();
		}
		
		}
}

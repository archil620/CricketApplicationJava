package com.igate.cricketapplication.dao;

import java.sql.Connection  ; 
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.igate.cricketapplication.exception.CricketAppException;



public class DbConnection {
	
	//@Resource(lookup="java:/jdbc/MyDS")
	static DataSource ds;

	public static Connection getConnection() throws CricketAppException {
		Connection conn = null;
		System.out.println("In getConnection class************************");
	
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/jdbc/myDSN");
			conn= ds.getConnection(); 
			if(conn!=null)
				System.out.println("************************Connected**************************");
			
		}

		catch (SQLException e) {
			throw new CricketAppException("SQL Error:"+e.getMessage());
		} catch (NamingException e) {
			throw new CricketAppException("message from DB/NamingExc:"
					+ e.getMessage());
		}
		return conn;
	}
}

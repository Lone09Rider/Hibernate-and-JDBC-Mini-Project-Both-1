package com.STudent.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con;
	
	public static Connection cretaeConn() {
		try {
//		Load
			Class.forName("com.mysql.jdbc.Driver");
			
//			Create Connection
			String user = "root";
			String password = "123456";
			String url = "jdbc:mysql://localhost:3306/student_manage?autoReconnect=true&useSSL=false";
			con = DriverManager. getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}

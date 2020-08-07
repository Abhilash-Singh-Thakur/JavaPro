package com.student.test.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {

	public static final String Database_Driver = "com.mysql.cj.jdbc.Driver";
	public static final String Database_URL = "jdbc:mysql://localhost:3306/students_record";
	public static final String username = "root";
	public static final String Password = "root";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(Database_Driver);
			con = DriverManager.getConnection(Database_URL, username, Password);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;
	}
}

package MyConnection;

import java.sql.*;

public class ConnectionProvider {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DataBaseDetail.Database_Driver);
			con = DriverManager.getConnection(DataBaseDetail.Database_URL,DataBaseDetail.username,DataBaseDetail.Password);
		} catch (Exception e) {
		    e.printStackTrace();
		  
		}
		return con;
	}
}

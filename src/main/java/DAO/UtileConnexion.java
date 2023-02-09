package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtileConnexion {
public static Connection toConnect() {
		
		String DRIVER = "org.postgresql.Driver";
		String URL = "jdbc:postgresql://localhost:5432/TPJEE0702";
		String LOGIN = "postgres";
		String PASSWORD = "monSQLaMoi";
		Connection connection = null;

		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (SQLException e1) {
			System.out.println("SQLException");
		} catch (ClassNotFoundException e2) {
			System.out.println("ClassNotFoundException");
		}		
		return connection;
	}	
	

//	public static void main(String[] args) throws SQLException {
//		 
//		System.out.println("Open connection");
//		Connection con = UtileConnexion.toConnect();
//		con.close();
//		System.out.println("connection close");
//
//	}

}



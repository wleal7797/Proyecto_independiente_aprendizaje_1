package co.edu.unbosque.controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;


public class controller {
	
     
	public controller() {
	
		getConnection();
		
	}

	public static Connection getConnection() {
		String url, username, password;
		String db ="percolxyz";
		url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&use"
		+"JDBCCompliantTimezoneShift=true&useLegacyDatetimecode=false&"
				+"serverTimezone=UTC";
		username = "root";
		password = "0000";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		System.out.println("Conectado");	

		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Conectado");
			System.out.println(e.getMessage());
		}

		return con;
		
	}

 
	
     
	
}

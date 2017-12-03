package jdbcDatabase;

import java.sql.*;

public class DBConnection {

	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/DBProg32758";
	static String user = "root";
	static String pw = "1111";

	Connection con = null;
	Statement stmt = null;
	String sql = null;

	public String connection() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			// createTable();
			return "done";
		} else {
			return "fail";
		}

	}

	public void createDB() {

		try {
			DB_URL = "jdbc:mysql://localhost/";
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();

			sql = "CREATE DATABASE DBProg32758;";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void createTable() {

		try {
			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			sql = "CREATE TABLE Players(Last_Name VARCHAR(20), First_Name VARCHAR(20), CAR_Group VARCHAR(20), Login VARCHAR(50), Password VARCHAR(50), Prefered_Car_Name VARCHAR(20), Logo VARCHAR(20), Score INT);";
			stmt.executeUpdate(sql);

			stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	public void dropDB() {
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();

			sql = "DROP DATABASE DBProg32758;";
			stmt.executeUpdate(sql);

			stmt.close();
			// res.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

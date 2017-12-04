package jdbcDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Login {
	
	private String lastName = null;
	private String firstName = null;
	private String groupNum = null;
	private String login = null;
	private String password = null;
	private String pCar = null;
	private String credit = null;
	private String score = null;
	private String logo = null;
	
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/DBProg32758";
	static String user = "root";
	static String pw = "1111";

	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	String sql = null;
	
	ArrayList<String> lg = new ArrayList<String>();
	PreparedStatement ps = null;
	
	public Login()
	{
		
	}
	
	public Login(String lastName, String firstName, String groupNum,
			String login, String password, String pCar, String credit, String score, String logo)
	{
		this.lastName=lastName;
		this.firstName= firstName;
		this.groupNum = groupNum;
		this.login = login;
		this.password = password;
		this.pCar = pCar;
		this.credit = credit;
		this.score = score;
		this.logo = logo;
		
		
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getGroupNum() {
		return groupNum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lastName + "," + firstName + "," + groupNum;
	}
	
	
	public void createTable() {
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			sql = "CREATE TABLE idpassword(LastName VARCHAR(20), FirstName VARCHAR(20), GroupS VARCHAR(20), Login VARCHAR(50), Password VARCHAR(50), PreferedCar VARCHAR(20), Credit VARCHAR(20), Score VARCHAR(20), Logo VARCHAR(20));";
			stmt.executeUpdate(sql);

			stmt.close();
			con.close();


		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void inputData() {
		
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();

			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			
			String sqlInsert = "INSERT INTO idpassword(LastName, FirstName, GroupS) VALUES ('An', 'Joon', '3');";
			stmt.executeUpdate(sqlInsert);
			
			sqlInsert = "INSERT INTO idpassword(LastName, FirstName, GroupS) VALUES ('Sun', 'Jinuk', '3');";
			stmt.executeUpdate(sqlInsert);
			
			stmt.close();
			con.close();
			 

		} catch (Exception e) 
		{
			System.out.println(e);
		}

	}
	
public boolean updateTable() {
		
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();

			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			
			String sqlUpdate = "UPDATE idpassword SET Login = ?, Password = ?, PreferedCar = ?, Credit = ?, Score = ?, Logo = ? WHERE LastName = ? && FirstName=? && GroupS = ?";
			ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
			
			
			System.out.println(login + password + pCar + credit + score + logo + lastName + firstName + groupNum);
			
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setString(3, pCar);
			ps.setString(4, credit);
			ps.setString(5, score);
			ps.setString(6, logo);
			ps.setString(7, lastName);
			ps.setString(8, firstName);
			ps.setString(9, groupNum);
			
			ps.executeUpdate();
			
			
			stmt.close();
			con.close();
			 

		} catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
		
		return true;

	}

	public ArrayList<String> getData()
	{
		
		try
		{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			String sqlselect = "select * from idpassword;";	
			res = stmt.executeQuery(sqlselect);
			
			while(res.next())
			{
				setLastName(res.getString("LastName"));
				setFirstName(res.getString("FirstName"));
				setGroupNum(res.getString("GroupS"));
				lg.add(toString());
			}
			
		//	dataWrite(lg);
			
			//System.out.println(lg.size());
			res.close();
			stmt.close();
			con.close();

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		System.out.println(lg.size());
		
		return lg;	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login lg = new Login();
		//lg.getData();
		//lg.readFile();
		
		//System.out.println();
		
		lg.createTable();
		lg.inputData();

	}
	
}

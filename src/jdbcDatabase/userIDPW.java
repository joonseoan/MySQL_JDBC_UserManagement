package jdbcDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class userIDPW {
	
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
	
	public userIDPW()
	{
		
	}
	
	public userIDPW(String login, String password)
	{
		
		this.login = login;
		this.password = password;
		
	}
	
	public userIDPW(String lastName, String firstName, String groupNum,
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
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return login + "," + password;
	}
	
	
	public void createTable() {
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			sql = "CREATE TABLE idPassword(LastName VARCHAR(20), FirstName VARCHAR(20), GroupS VARCHAR(20), Login VARCHAR(50), Password VARCHAR(50), PreferedCar VARCHAR(20), Credit VARCHAR(20), Score VARCHAR(20), Logo VARCHAR(20));";
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
			
			String sqlInsert = "INSERT INTO idPassword(LastName, FirstName, GroupS, Login, Password) VALUES ('An', 'Joon', '3', 'anjo', '2222');";
			stmt.executeUpdate(sqlInsert);
			
			sqlInsert = "INSERT INTO idPassword(LastName, FirstName, GroupS, Login, Password) VALUES ('Sun', 'Jinuk', '3', 'jws', '1111');";
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
			
			
			
			String sqlUpdate = "UPDATE idPassword SET Password = 'xxxx' WHERE Login = ?";
			ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
			
			System.out.println(login);
			
			
			ps.setString(1, login);
			
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
			
			String sqlselect = "select * from idPassword;";	
			res = stmt.executeQuery(sqlselect);
			
			while(res.next())
			{
				setLogin(res.getString("Login"));
				setPassword(res.getString("Password"));
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
		//System.out.println(lg.size());
		
		return lg;	
	}
	
	/*
	
	public void dataWrite(ArrayList<String> data)
	{
		try 
		{
			File file = new File("idPassword.txt");
			
			if (!file.exists())
			{
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < data.size(); i++)
			{
				bw.write(data.get(i));
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		}
		catch (Exception ie)
		{
			System.out.println(ie);
		}
		
	}

	public ArrayList<String> readFile()
	{
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			
			File file = new File("idPassword.txt");

			if (!file.exists()) {
				throw new FileNotFoundException("File ....does not exists.");
			}

			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);

			String s;
			
			while ((s = br.readLine()) != null) {
				
				al.add(s);
				System.out.println(s);
				System.out.println(al.size());
			}

			br.close();
			fr.close();
			
		} catch (IOException ie) {
			System.out.println("Failed to Read");
		}
		
		return al;
	}
	*/
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userIDPW uip = new userIDPW();
		
		//lg.getData();
		//lg.readFile();
		
		//System.out.println();
		
		uip.createTable();
		uip.inputData();

	}
	
}

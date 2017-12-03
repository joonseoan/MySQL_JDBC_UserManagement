package jdbcDatabase;

import java.io.*;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class StudentList {

	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/DBProg32758";
	static String user = "root";
	static String pw = "1111";

	Connection con = null;
	Statement stmt = null;
	String sql = null;

	File file = null;
	FileReader fr = null;
	BufferedReader br = null;

	String s = null;

	String lastName = null;
	String firstName = null;
	int group = 0;

	PreparedStatement ps = null;
	ResultSet res = null;

	public void readFile() {
		try {
			file = new File("Prog32758Students.txt");

			if (!file.exists()) {
				throw new FileNotFoundException("File does not exist.");
			}

			fr = new FileReader(file.getAbsoluteFile());
			br = new BufferedReader(fr);

		} catch (IOException ie) {
			System.out.println("Failed to Read");
		}

	}

	public void inputData() {
		try {
			DB_URL = "jdbc:mysql://localhost/DBProg32758";
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();

			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);

			
			 
			 String sql ="CREATE TABLE Prog32758Students(Last_Name VARCHAR(20), First_Name VARCHAR(20), Stu_Group INT);";
			 stmt.executeUpdate(sql); // stmt.executeQuery(sql);
			 

			while ((s = br.readLine()) != null) {

				String[] arr = s.split(",");
				lastName = arr[0];
				firstName = arr[1];
				group = Integer.parseInt(arr[2]);
	
				insertData(lastName, firstName, group);

			}

			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void insertData(String lastName, String firstName, int group) 
	{
		try {
			String sqlInsert = "INSERT INTO Prog32758Students(Last_Name, First_Name, Stu_Group) VALUES (?, ?, ?);";

			ps = (PreparedStatement) con.prepareStatement(sqlInsert);
			
			ps.setString(1, lastName);
			ps.setString(2, firstName);
			ps.setInt(3, group);

			ps.executeUpdate();

			

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void selectData()
	{
		try
		{
		String sqlSelect = "select Last_Name, First_Name from Prog32758Students ;";
		res = stmt.executeQuery(sqlSelect);
		
		System.out.println("Last Name" + "     " + "First Name" + "                            " +    "Last Name(File)" + "     " + "First Name(File)");
		
		
		

	
		
		while(res.next() && (s = br.readLine()) != null)
		{
			String[] arr = s.split(",");
			lastName = arr[0];
			firstName = arr[1];
			System.out.println(res.getString("Last_Name") + "            " + res.getString("First_Name") + "                                    " + lastName + "            " + firstName);
		}


		
		stmt.close();
		con.close();
		
		br.close();
		fr.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

	
	

}

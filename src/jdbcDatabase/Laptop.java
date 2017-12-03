package jdbcDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Laptop {
	
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost/db1";
	static String user = "root";
	static String pw = "1111";

	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	String sql = null;
	
	ArrayList<String> laptopList = new ArrayList<String>();
	
	String owner = null;
	String model = null;
	String manufacturer = null;
	String screen;
	String year;
	
	public void deriveData() {
		
		try 
		{
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			// String sqlUse = "use db1;";
			
			
			System.out.println("Owner   Model    Manufact       Screen   Year" );
			
			String sqlselect = "select * from Laptop;";	
			res = stmt.executeQuery(sqlselect);
			
			while(res.next())
			{
				
			   /*
				System.out.println(res.getString("Owner") + " " + res.getString("Model") + " " +res.getString("Manufacturer")
				+ " " + res.getInt("Screen") + " " + res.getInt("Year"));
				*/
				owner = res.getString("Owner");
				model = res.getString("Model");
				manufacturer = res.getString("Manufacturer");
				screen = String.valueOf(res.getInt("Screen"));
				year = String.valueOf(res.getInt("Year"));
				
				laptopList.add(owner + "     " + model + "     " + manufacturer + "     " + screen + "     " + year);
				/*
				laptopList.add(owner);
				laptopList.add(model);
				laptopList.add(manufacturer);
				laptopList.add(screen);
				laptopList.add(year);	
				*/
			}
			
			writeToFile(laptopList);
			
			res.close();
			stmt.close();
			con.close();
				
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//public void writeToFile(String owner, String model, String manufacturer, int screen, int year)
	public void writeToFile(ArrayList data)
	{
		try
		{
			File file = new File("LaptopNote.txt");
			
			if (!file.exists())
			{
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < data.size(); i++)
			{
				
				String s = (String)data.get(i);
				bw.write(s);
				bw.newLine();
				
			}
			
			bw.close();
			fw.close();
		}
		catch (Exception e)
		{
			System.out.println(e + "  Writing Error");
		}
	}

	public ArrayList<String> readFile()
	{
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			
			
			File file = new File("LaptopNote.txt");

			if (!file.exists()) {
				throw new FileNotFoundException("File Exists.");
			}

			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);

			String s;
			
			while ((s = br.readLine()) != null) {
				
				al.add(s);
				System.out.println(s);
			}

			br.close();
			fr.close();
			
		} catch (IOException ie) {
			System.out.println("Failed to Read");
		}
		
		return al;
	}
	
	/*
	public static void main (String[] args)
	{
		Laptop lt = new Laptop();
		lt.deriveData();
		lt.readFile();
	}
	*/
}

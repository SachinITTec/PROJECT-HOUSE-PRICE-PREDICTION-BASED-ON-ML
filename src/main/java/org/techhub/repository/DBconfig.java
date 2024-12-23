package org.techhub.repository;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class DBconfig {
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	private static DBconfig db;
	protected static CallableStatement cstmt;
	private DBconfig()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			File f=new File("");
			String path=f.getAbsolutePath();
			FileInputStream inputstream=new FileInputStream(path+"\\src\\main\\resources\\dbconfig.properties");
			Properties p=new Properties();
			p.load(inputstream);
			
			String driverClassName=p.getProperty("driver");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			String url=p.getProperty("url");
			
			
			 conn=DriverManager.getConnection(url,username,password);
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		
		
	}
	public static DBconfig getInstance()
	{
		if(db==null)
		{
			db=new DBconfig();
		}
		return db;
		
	}
	public static Connection getConn()
	{
		return conn;
	}
	
	public static PreparedStatement getStatement()
	{
		return stmt;
	}
	
	public static ResultSet getResult()
	{
		return rs; 
	}
	
	public static CallableStatement getCallable()
	{
		return cstmt;
	}
	
}
package com.seclore.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

	
	public static Connection getConnection() {
		
		try {
			InputStream is=DbManager.class.getResourceAsStream("db.properties");
			Properties p=new Properties();
			p.load(is);
			Class.forName(p.getProperty("driver"));
			return DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
			
		}
		catch(ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

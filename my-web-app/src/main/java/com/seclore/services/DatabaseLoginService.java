package com.seclore.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseLoginService {

	public int isValidUser(String uname,String pwd) {
		
		Connection conn=null;
		
		try {
			
			conn=DbManager.getConnection();
			PreparedStatement stmt=conn.prepareStatement("Select locked from app_user where uname=? and password=? ");
			stmt.setString(1, uname);
			stmt.setString(2, pwd);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				boolean locked=rs.getBoolean(1);
				if(!locked)
					return 1;
				else
					return 2;
			}
			
			
		
		
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {
		}
		
		
	}
		return 0;
}
	}

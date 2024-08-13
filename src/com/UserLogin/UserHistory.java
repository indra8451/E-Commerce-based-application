package com.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.connecction.ConnectionInstnace;

public class UserHistory {
	
	
	public static void printUserHistory(User loginuser) throws SQLException {
		
		if (loginuser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginuser.getRole().equals("customer") || loginuser.getRole().equals("Guest")) {
        	
        	System.out.println("This operation can only be performed by an Admin.");

        	 return;
        }
	
		ArrayList<User> userlist= new ArrayList<User>();
		Connection conn=null;
		PreparedStatement prepareStatement=null;
		try {
		
		
		conn=ConnectionInstnace.getConnection();
		String sql="select * from User"; 
		 prepareStatement = conn.prepareStatement(sql);

        ResultSet rs = prepareStatement.executeQuery();

     
        while (rs.next()) {
            
        	userlist.add(new User(rs.getInt("Uid"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("UserName"), rs.getString("Password"), rs.getString("City"), rs.getString("Email"), rs.getString("Phone"),rs.getString("Role")));
          
		} 
       // System.out.println(userlist);
        
        for(User user:userlist) {
			
			System.out.println("Username>>"+user.getUserName());
			System.out.println("First name>>"+user.getFirstName());;
			System.out.println("Last name>>"+user.getLastName());
			System.out.println("Email id>>"+user.getEmail());
			System.out.println("Mobile>>"+user.getPhone());
			System.out.println("City>>"+user.getCity());
			System.out.println();
	
			
		}
        
		}catch(SQLException e) {
	            e.printStackTrace();
		} finally {
			
			// Close the resources
	        prepareStatement.close();
	        conn.close();
		}
}


}

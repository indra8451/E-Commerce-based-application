package com.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.connecction.ConnectionInstnace;

public class UserLogin {
	
	
	
	public static User userValid(User loginuser) throws SQLException {
		
		if(loginuser!=null)
		{
			  loginuser= null;
		}
		   loginuser= null;
		
		try
		{
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the username>>");
		String username=scanner.next();
		System.out.println("Enter the password>>");
		String password=scanner.next();
		Connection conn=ConnectionInstnace.getConnection();
		String sql="SELECT * FROM User WHERE UserName = ? AND Password = ?";
		PreparedStatement ptst=conn.prepareStatement(sql);
		ptst.setString(1, username);
		ptst.setString(2, password);
		ResultSet rs=ptst.executeQuery();
		
		if(rs.next())
		{
			loginuser=new User(rs.getInt("Uid"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("UserName"), rs.getString("Password"), rs.getString("City"), rs.getString("Email"), rs.getString("Phone"),rs.getString("Role"));
			
        }
		
		if(loginuser.getRole().equals("customer") || loginuser.getRole().equals("Guest") ) {
			
			String sql2 = "SELECT Pid FROM orders WHERE Status = 'Pending Payment'";
	         PreparedStatement ptst3 = conn.prepareStatement(sql2);
	         ResultSet rs1 = ptst3.executeQuery();

	         String sql3 = "delete from orders  WHERE Pid = ?";
	         PreparedStatement ptst2 = conn.prepareStatement(sql3);

	         while (rs1.next()) {
	             int pid = rs1.getInt("Pid");
	             ptst2.setInt(1, pid);
	             ptst2.addBatch(); // Add the update to the batch
	         }

	         // Execute the batch of updates
	        ptst2.executeBatch();  //Previous User cart Deleted

	         // Check the results
	         /*for (int count : updateCounts) {
	             if (count > 0) {
	                 System.out.println("Previous User card Deleted!!!!!");
	             }
	         }*/

	         ptst2.close();;
		}
		 
		
		} catch(InputMismatchException e) {
    		
    		System.out.println("Invalid input! Please enter a number.");
    		
    		
    	}
		
		System.out.println(loginuser);
		return loginuser;
		
		
		
		
		
		
		
		
		
	}

}

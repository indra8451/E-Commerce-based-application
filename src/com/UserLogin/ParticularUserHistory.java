package com.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connecction.ConnectionInstnace;

public class ParticularUserHistory {
	
	

	public static void userHistoryWithProduct(User loginuser) throws SQLException {
		
		if (loginuser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginuser.getRole().equals("customer") || loginuser.getRole().equals("Guest")) {
        	
        	System.out.println("This operation can only be performed by an Admin.");

        	 return;
        }
		
		       Connection conn=null;
	
		       try {
		    	      conn=ConnectionInstnace.getConnection();
					  System.out.println("Enter the User id>>");
					  Scanner scanner= new Scanner(System.in);
					    int uid=scanner.nextInt();
						String sql="Select Products.Pid,Description,orders.quantity from Products INNER JOIN orders on Products.Pid = orders.Pid where Uid=?";
								
						PreparedStatement ptst= conn.prepareStatement(sql);
						ptst.setInt(1, uid);
						ResultSet rs=ptst.executeQuery();
						
						while(rs.next()) {
						
						System.out.println("Product id>>"+rs.getInt("Pid"));
						System.out.println("Product Description>>" + rs.getString("Description"));
						System.out.println("Quantity>>"+rs.getInt("quantity"));
					} 
		       } catch(NullPointerException e) {
		    	   
		    	   System.out.println("Something went Wrong!!!");
		       } finally {
		    	   conn.close();
		       }
			      
				
			
			
		} 
		
		 
	}



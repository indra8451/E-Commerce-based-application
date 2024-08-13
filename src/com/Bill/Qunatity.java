package com.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class Qunatity {
	
	public static void checkQuantity(User loginuser ) throws SQLException {
		if (loginuser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginuser.getRole().equals("customer") || loginuser.getRole().equals("Guest")) {
        	
        	System.out.println("This operation can only be performed by an Admin.");

        	 return;
        }
		
		Connection conn=null;
		
			try {
					System.out.println("Enter Product Id>>");
					Scanner scanner= new Scanner(System.in);
					int id=scanner.nextInt();
		             conn =ConnectionInstnace.getConnection();
		            String sql = "SELECT * FROM Products where Pid=?";
		            PreparedStatement prepareStatement = conn.prepareStatement(sql);
		            prepareStatement.setInt(1, id);
		            ResultSet rs = prepareStatement.executeQuery();

		            if (rs.next()) {
		            	
		            	
		                if (rs.getInt("Pid") == id) {
		                
		                    
		                    int quantity = rs.getInt("Quantity");
		                    System.out.println("Quantity is>>"+quantity);
		                    
		                    
		                  
		                   
		     	} 
					
	            
			
		}
			}catch(Exception  e) {
		e.printStackTrace();
	}finally {
		
		conn.close();
	}
	
	
	}
}


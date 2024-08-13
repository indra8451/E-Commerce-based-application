package com.ProductInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class PurchaseItem {
	
	public static void purchaseItem(User loginUser) throws SQLException {
		
				if (loginUser == null) {
		            System.out.println("Please login first.");
		            return;
		        } else if(loginUser.getRole().equals("Guest") || loginUser.getRole().equals("Admin")) {
		        	
		        	System.out.println("This operation can only be performed by an User.");
		
		        	 return;
		        }			Connection conn=null;
		
		try {
			 
	            conn =ConnectionInstnace.getConnection();
	            String sql = "SELECT Status, Uid, SUM(total_amount) AS total_sum FROM `velocitye-comm`.`orders` WHERE Uid = ? AND Status = 'Pending Payment' GROUP BY Status, Uid";
	            //"SELECT * FROM orders  ORDER BY id DESC LIMIT ?";
	           
	            PreparedStatement ptst = conn.prepareStatement(sql);
	            ptst.setInt(1, loginUser.getUid());
	            ResultSet rs = ptst.executeQuery();

	            if (rs.next()) {
	               
	                	
	                    String username =loginUser.getUserName();
	                    System.out.println("Username>>"+username);
	                    
	                    int total_sum = rs.getInt("total_sum");
	                    System.out.println("Total Bill Amount>>"+total_sum);
	                  
	                   
	     	} 
				
                

			
		}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		conn.close();
	}
	
}

	}

	
	


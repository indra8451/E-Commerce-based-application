package com.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Main;
import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class DisplayAmount {
	
	public static void totalBilling(User loginUser) throws SQLException {
		
		
		if (loginUser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginUser.getRole().equals("customer") || loginUser.getRole().equals("Guest")) {
        	
        	System.out.println("This operation can only be performed by an Admin.");

        	 return;
        }
	
		   Connection conn=null;
		
		try {
			 
	            conn =ConnectionInstnace.getConnection();
	            String sql = "SELECT o.Status, o.Uid, u.UserName, SUM(o.total_amount) AS total_sum FROM `velocitye-comm`.`orders` o JOIN `velocitye-comm`.`User` u ON o.Uid = u.Uid WHERE o.Status = ? GROUP BY o.Status, o.Uid, u.UserName";
	        
	           
	            PreparedStatement ptst = conn.prepareStatement(sql);
	            ptst.setString(1, "Pending Payment");
	            ResultSet rs = ptst.executeQuery();

	            if (rs.next()) {
	               
	                	
	                    String username =rs.getString("u.UserName");
	                    System.out.println("Username>>"+username);
	                    
	                    int total_sum = rs.getInt("total_sum");
	                    System.out.println("Display the amount to End User>>"+total_sum);
	                    
	                    String sql2 = "SELECT Pid FROM orders WHERE Status = 'Pending Payment'";
	                    PreparedStatement ptst3 = conn.prepareStatement(sql2);
	                    ResultSet rs1 = ptst3.executeQuery();

	                    String sql3 = "UPDATE orders SET Status = 'Pending Done' WHERE Pid = ?";
	                    PreparedStatement ptst2 = conn.prepareStatement(sql3);

	                    while (rs1.next()) {
	                        int pid = rs1.getInt("Pid");
	                        ptst2.setInt(1, pid);
	                        ptst2.addBatch(); // Add the update to the batch
	                    }

	                    // Execute the batch of updates
	                    int[] updateCounts = ptst2.executeBatch();

	                    // Check the results
	                    for (int count : updateCounts) {
	                        if (count > 0) {
	                            System.out.println("Status Changed!!!!!");
	                        }
	                    }

	                    ptst2.close();
	                    ptst3.close();

	                    
	                    
	                  
	                   
	     	} 
				
                

			
		}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		conn.close();
	}
	
}

	}

	
	


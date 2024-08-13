package com.BuyProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Main;
import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class BuyProduct {
	
	public static  void buyProduct(User loginUser) throws SQLException {
		 if (loginUser == null) {
	            System.out.println("Please login first.");
	            return;
	        } else if(loginUser.getRole().equals("Guest") || loginUser.getRole().equals("Admin")) {
	        	
	        	System.out.println("This operation can only be performed by an User.");

	        	 return;
	        }
		Connection conn=null;
		Scanner scanner= new Scanner(System.in);
		try {
			conn=ConnectionInstnace.getConnection();
			System.out.println("Enter the product id to buy product: ");
            int productId = scanner.nextInt();
            System.out.println("Enter the quantity: ");
            int quantity = scanner.nextInt();
            if(quantity<=0) {
            	System.out.println("Enter quatity aleast 1");
            	return;
            }
			String sql="select * from Products where Pid=?";
			PreparedStatement preparestatment=conn.prepareStatement(sql);
			preparestatment.setInt(1, productId);
			ResultSet rs=preparestatment.executeQuery();
			int uid= loginUser.getUid();
			if(rs.next()) {
				
				
				if( rs.getInt("Quantity")>=quantity ) {
					
					double total_amount=rs.getInt("price")*quantity;
					String sql1= "insert into `velocitye-comm`.`orders`(Uid,Pid,quantity,total_amount,Status) values (?,?,?,?,?)";
					PreparedStatement ptst=conn.prepareStatement(sql1);
					System.out.println("User ID " +loginUser.getUid());
					ptst.setInt(1,uid);
					ptst.setInt(2, productId);
					System.out.println("Product ID " +productId);
					
					ptst.setInt(3, quantity);
					ptst.setDouble(4, total_amount);
					ptst.setNString(5, "Pending Payment");
					int j=ptst.executeUpdate();
					if(j>0) {
						
						Main.purchaseProductCount++;
						System.out.println("Quantity updated. Rows affected: " + j);
					} 
					
			        
			        int remainimg_quantity=rs.getInt("Quantity")-quantity;
					String sql3="UPDATE Products set Quantity = ?  WHERE Pid = ?";
					PreparedStatement ptst2=conn.prepareStatement(sql3);
					ptst2.setInt(1, remainimg_quantity);
					ptst2.setInt(2, productId);
					int i=ptst2.executeUpdate();
					System.out.println("Quantity updated. Rows affected: " + i);
					//System.out.println("Do you want to view cart (Yes/No)");
					
				} else {
					
					System.out.println("Insufficient Quantity Try for another  product!!!");
				}
			} else {
                System.out.println("Product not found.");
                return;
			}
			
			
			 
			
			
		} catch(InputMismatchException  e) {
			System.out.println("Invalid input! Please enter a number.\n");
		}catch ( NullPointerException e){
			
			System.out.println("Login first");
		}
		finally {
			
			
		}
	
	} 

}

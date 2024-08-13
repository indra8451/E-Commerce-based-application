package com.ProductInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class PrintProductList {
	
	public static void printproductList(User loginUser) throws SQLException {
		if (loginUser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginUser.getRole().equals("customer") || loginUser.getRole().equals("Admin")) {
        	
        	System.out.println("This operation can only be performed by an Guest.");

        	 return;
        }
		Connection conn=null;
		ArrayList<Product>productlist= new ArrayList<Product>();
		try {
			
			conn=ConnectionInstnace.getConnection();
			String sql="SELECT * FROM Products";
			PreparedStatement preparestatment=conn.prepareStatement(sql);
			ResultSet rs=preparestatment.executeQuery();
			
			while(rs.next()) {
				
				productlist.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),(rs.getInt(5))));
			}
			
			
			
            for(Product product:productlist) {
				
				System.out.println("Product Id>>"+product.getPid());
				System.out.println("Product Description>>"+product.getDescription());
				System.out.println("Amount>>"+ product.getPrice());
				System.out.println("Quantity>>"+product.getQuantity());
				System.out.println();
				
			}
			
           // System.out.println(productlist);
		} catch(InputMismatchException e) {
			System.out.println("Somethoing wrong");
		}finally {
			
			conn.close();
		}
		
	}

	

}

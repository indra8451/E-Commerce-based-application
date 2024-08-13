package com.ProductInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.connecction.ConnectionInstnace;

public class SortedNameOrder {

	public static void sortedNameOrder() throws SQLException {
		
		Connection conn=null;
		ArrayList<Product>productlist= new ArrayList<Product>();
		try {
			
			conn=ConnectionInstnace.getConnection();
			String sql="SELECT * FROM Products ORDER BY Name";
			PreparedStatement preparestatment=conn.prepareStatement(sql);
			ResultSet rs=preparestatment.executeQuery();
			
			while(rs.next()) {
				
				productlist.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),(rs.getInt(5))));
			}
			
			
			
            for(Product product:productlist) {
				
				System.out.println("Product Id>>"+product.getPid());
				System.out.println("Product Description>>"+product.getDescription());
				System.out.println("Product Name>>" + product.getName());
				System.out.println("Price>>"+ product.getPrice());
				System.out.println("Available Quantity>>"+product.getQuantity());
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

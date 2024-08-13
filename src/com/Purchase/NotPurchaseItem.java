package com.Purchase;
import java.sql.SQLException;
import com.BuyProduct.BuyProduct;
import com.UserLogin.User;


public class NotPurchaseItem {
	

	
	public static void notPurchaseItemByGuest(User loginUser) throws SQLException {
		
		try {
			
			BuyProduct.buyProduct(loginUser);
		} catch(Exception e) {
			
			System.out.println("Something went Wrong!!!");
		}
		
		
			
	}
}

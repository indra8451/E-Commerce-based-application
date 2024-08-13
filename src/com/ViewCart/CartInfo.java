package com.ViewCart;

import com.Main;
import com.UserLogin.User;

public class CartInfo {
	
	public static void viewCart(User loginUser) {
	
	if (loginUser == null) {
        System.out.println("Please login first.");
        return;
    } else if(loginUser.getRole().equals("Admin") || loginUser.getRole().equals("Guest")) {
    	
    	System.out.println("This operation can only be performed by an User.");

    	 return;
    } else {
    	
    	System.out.println(Main.purchaseProductCount+" "+"Product item has been added to cart");
    }

}
	
}

package com.Bill;

import com.UserLogin.User;

public class CalculateTheBill {
	
	public static void calculateBill(User loginuser) {
		if (loginuser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginuser.getRole().equals("customer") || loginuser.getRole().equals("Guest")) {
        	
        	System.out.println("This operation can only be performed by an Admin.");

        	 return;
        } else {
        	System.out.println("Admin will calculate the bill");
        }
		
		
	}

}

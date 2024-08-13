package com;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Bill.CalculateTheBill;
import com.Bill.DisplayAmount;
import com.Bill.Qunatity;
import com.BuyProduct.BuyProduct;
import com.ProductInfo.PrintProductList;
import com.ProductInfo.PurchaseItem;
import com.ProductInfo.SortedNameOrder;
import com.ProductInfo.productItem;
import com.Purchase.NotPurchaseItem;
import com.UserLogin.ParticularUserHistory;
import com.UserLogin.User;
import com.UserLogin.UserHistory;
import com.UserLogin.UserLogin;
import com.UserOperation.UserRegistration;
import com.ViewCart.CartInfo;
public class Main {
	static User loginUser=null;
	public static int purchaseProductCount;
	public static void startPoint() throws SQLException {
		
		
		
		try
		{
		System.out.println("Welcome to E-Commerce based application\n");
		System.out.println("User Operation\n");
		System.out.println("1. User Registration");
		System.out.println("2. User Login");
		System.out.println("3. User view Product item as Sorted Order");
		System.out.println("4. Buy Product");
		System.out.println("5. View Cart ");
		System.out.println("6. Purchase the item\n"); 
		System.out.println("Admin Operation\n");
		System.out.println("7. Add product item");
		System.out.println("8. Calculate Bill");
		System.out.println("9. Display amount to End User");
		System.out.println("10.Check Quantity");
		System.out.println("11. Check registered user");
		System.out.println("12. Check the particular user history\n");
		System.out.println("Guest Operation\n");
		System.out.println("13. View product item");
		System.out.println("14. Not purchase item");
		
	
	
		Scanner scanner=new Scanner(System.in);
		
		
		while(true) {
		System.out.print("Enter your choice-");
		int choice=scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
		case 1:  UserRegistration.userDetails();
				 break;
		        
		case 2: loginUser=UserLogin.userValid(loginUser);
				if(loginUser!=null) {
					
					// purchaseProductCount=0;
					 System.out.println("login  User: "+loginUser.getRole());
					 //System.out.println("Purchase Product Count Current User :"+purchaseProductCount);
					 System.out.println("User logged in successfully!!!!\n");
					
				}
				else {
					
					System.out.println("Please Login first to continue!!!!");
					main(null);
				}
				break;
		case 3: SortedNameOrder.sortedNameOrder();
				break;
				
		case 4: BuyProduct.buyProduct(loginUser);
		        //System.out.println("Purchase Product Count Current User :"+purchaseProductCount);
				break;
		case 5:CartInfo.viewCart(loginUser);
				break;
		case 6:	PurchaseItem.purchaseItem(loginUser);	  //not done
				break;
		case 7:productItem.addProduct(loginUser);
				break;
		case 8:CalculateTheBill.calculateBill(loginUser);
		       break;
		case 9:DisplayAmount.totalBilling(loginUser);	  //not done
		       break;
		case 10:Qunatity.checkQuantity(loginUser);
		        break;
		case 11:UserHistory.printUserHistory(loginUser);
		        break;
		case 12:ParticularUserHistory.userHistoryWithProduct(loginUser);
			   break;    
		case 13:PrintProductList.printproductList(loginUser);
				break;
		case 14:NotPurchaseItem.notPurchaseItemByGuest(loginUser);
		        break;
		default:System.out.println("Enter correct choice");		
		        
		}
	}
		
		}catch(InputMismatchException  | SQLException e) {
		
		System.out.println("Invalid input! Please enter a number.\n");
		main(null);
		
		
	} finally {
		
		
	}
}
	

	public static void main(String[] args) throws SQLException {
		
		startPoint();

	}

}


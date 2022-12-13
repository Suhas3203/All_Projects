package com.Banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainForBankingAPP {

	public static void main(String[] args) {

		Scanner scanObj=new Scanner(System.in);
		AccountDetails acDetails=new AccountDetails();
		List<AccountDetails> accountData= new ArrayList<>();

		System.out.println("*-----------Welcome To My Banking Application---------*\n\n");
		int ctr = 0;
		do {
			System.out.println("*----------------------*----------------------*");
			System.out.println("Press 1 for Creating New Account");
			System.out.println("Press 2 for Deposit Amount in Account");
			System.out.println("Press 3 for Withdraw Amount from your Account");
			System.out.println("Press 4 for Showing Balance of Account");
			System.out.print("Enter Your choice :- ");
			ctr=scanObj.nextInt();
			switch(ctr) {
				case 1:
					System.out.print("Enter Code :- ");
					String codeOfAccount=scanObj.next();
					System.out.print("Enter Name of Account Owner :- ");
					String nameOfOwner=scanObj.next();
					accountData.add(acDetails.createNewAccount(codeOfAccount,nameOfOwner)); 
					System.out.println("Account Created Sucessfully");
					break;
				case 2:
					System.out.println("Enter Amount to deposit :- ");
					int amountToBeDeposited=scanObj.nextInt();
					acDetails.depositAmountInAccount(amountToBeDeposited);
					System.out.println("Now your Account Balance is "+ acDetails.getAmount());
					break;
				case 3:
					System.out.println("Enter Amount to be Withdrawn :- ");
					int amountToWithdrawn=scanObj.nextInt();
					acDetails.withdrawAmountFromAccount(amountToWithdrawn);
					System.out.println("Remaining Balance in Your Account :- "+ acDetails.getAmount());
					break;
				case 4:
					if(accountData.isEmpty()) {
						System.out.println("Their is no record inserted");
					}else {
						System.out.println(accountData);
					}
					System.out.println("Enter which record you want to See :-");
					int counter =scanObj.nextInt();
					System.out.println("<------- Here are Your Account Details -------> ");
					try {
						acDetails.showBalanceOfAccount(accountData.get(counter));
					}catch(Exception obj) {
						System.out.println("You havn't Opened any Account yet");
					}
					break;
				default:
					System.out.println("You Entered incorrect choice, Please try again.");
					break;
			}

		} while(ctr<=4 );


		scanObj.close();
	}

}

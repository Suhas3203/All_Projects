package com.BankingApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;


public class mainForBankingAPP {
	static Scanner scanObj=new Scanner(System.in);
	public static void addAccountDetails(Connection connection,AccountDetails  obj) throws SQLException {//method for inserting values
		PreparedStatement pstmt = connection.prepareStatement("insert into accountdetails values(?,?,?) ");
		pstmt.setString(1, obj.getAccoutNum());
		pstmt.setString(2, obj.getNameOfAccountOwner());
		pstmt.setInt(3, obj.getAmount());
		pstmt.executeUpdate();
		System.out.println("Record Inserted Sucessfully");
	}

	private static AccountDetails getSoftwareDetails() {
		AccountDetails acDetails=new AccountDetails();
		System.out.print("Enter Account Number :- ");
		acDetails.setAccoutNum(scanObj.next());
		System.out.print("Enter Name of Account Owner :- ");
		acDetails.setNameOfAccountOwner(scanObj.next());

		acDetails.setAmount(0);
		return acDetails;
	}

	public static void updateAccountDetails(Connection connection,String accountNum) throws SQLException {//method for to update record
		PreparedStatement pstmt = connection.prepareStatement("update  accountdetails set  Amount=? where accountNum=?");//update query
		System.out.println("Enter Amount to deposit :- ");
		int amountToBeDeposited=scanObj.nextInt();
		pstmt.setInt(1, amountToBeDeposited);
		pstmt.setString(2, accountNum);
		pstmt.executeUpdate();
		System.out.println("Your Amount added to your account Successfully");
	}


	public static void viewAccountBalance(Connection connection,String accountNum) throws SQLException {//method for view record
		PreparedStatement pstmt = connection.prepareStatement("select * from accountdetails where accountNum=?");//selct query same as mysql
		pstmt.setString(1, accountNum);
		ResultSet record=pstmt.executeQuery();
		while(record.next()) {
			System.out.println(record.getString(1)+" "+record.getString(2)+" "+record.getInt(3));

		}
	}

	public static void withdrawnMoneyFromAccount(Connection connection,String accountNum)throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement("select Amount from accountdetails where accountNum=?");//selct query same as mysql
		pstmt.setString(1, accountNum);

		ResultSet record=pstmt.executeQuery();
		int remainingBalance = 0;
		while(record.next()) {
			remainingBalance=record.getInt(1);
		}
		System.out.println("Enter Amount to be Withdrawn :- ");
		int amountToWithdrawn=scanObj.nextInt();
		if(remainingBalance>=amountToWithdrawn) {
			remainingBalance -=amountToWithdrawn;
			pstmt=connection.prepareStatement("update  accountdetails set  Amount=? where accountNum=?");
			pstmt.setInt(1, remainingBalance);
			pstmt.setString(2, accountNum);
			pstmt.executeUpdate();
			System.out.println("Your Amount Withdrawn done Sucessfully");
		}
		else {
			System.out.println("You haven't Sufficient Balance in your Account");
			System.out.println("Your Remaining Balance :- "+ remainingBalance);
		}
	}

	public static void deleteAccountDetails(Connection connection,String accountNum) throws SQLException {//method for to delete record
		PreparedStatement pstmt = connection.prepareStatement("delete from accountdetails where accountNum=?");//dlete query
		pstmt.setString(1, accountNum);
		pstmt.executeUpdate();
		System.out.println("Your Account deleted Successfully");
	}


	public static void main(String[] args) throws SQLException, Exception {

		Connection connection=null; 
		Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root" ,"Suhas3203@");//establishing connection


		System.out.println("*-----------Welcome To My Banking Application---------*\n\n");
		int ctr = 0;
		do {
			System.out.println("*----------------------*----------------------*");
			System.out.println("Press 1 for Creating New Account");
			System.out.println("Press 2 for Deposit Amount in Account");
			System.out.println("Press 3 for Withdraw Amount from your Account");
			System.out.println("Press 4 for Showing Balance of Account");
			System.out.println("Press 5 for Deleting Existing Account");
			System.out.print("Enter Your choice :- ");
			ctr=scanObj.nextInt();
			switch(ctr) {
				case 1:
					AccountDetails accDetails= getSoftwareDetails();
					if(connection!=null) {
						addAccountDetails(connection,accDetails); //method call
						System.out.println("Your Account have '0' Balance, deposit money");
					}
					else {
						System.out.println("check your connection");
					}

					break;
				case 2:
					System.out.println("enter which AccountNumber Details do you want to update");
					updateAccountDetails(connection,scanObj.next());
					//	System.out.println("Now your Account Balance is "+ acDetails.getAmount());
					break;

				case 3:
					System.out.println("enter which AccountNumber Details do you want to withdrawn money");
					withdrawnMoneyFromAccount(connection, scanObj.next());
					break;

				case 4:
					System.out.println("Enter Your Account number to See your balance:-");
					String accountCode=scanObj.next();
					viewAccountBalance(connection, accountCode);

					break;

				case 5:
					System.out.println("Enter Your Account number You want to Delete that Account:-");
					String accountNumber=scanObj.next();
					deleteAccountDetails(connection, accountNumber);
					break;
				default:
					System.out.println("You Entered incorrect choice, Please try again.");
					break;
			}

		} while(ctr<=4 );

		connection.close();
		scanObj.close();
	}

}

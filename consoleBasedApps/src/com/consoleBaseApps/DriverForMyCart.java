package com.consoleBaseApps;


import java.text.SimpleDateFormat;
import java.util.*;

public class DriverForMyCart {
	static Address newAddress;
	static Scanner userObj=new Scanner(System.in);
	static Person personObj=new Person();
	static Random generator=new Random();

	public static int getRandomInRange(int start, int end) {
		return start + generator.nextInt(end - start + 1);
	}

	public static void main(String[] args) throws Exception {


		Calendar calender=Calendar.getInstance();
		SimpleDateFormat formatDate=new SimpleDateFormat("dd-MM-yyyy");

		try {

			System.out.println("!.... Welocome to My Cart App ....!");
			System.out.println("--------------------------------------");
			int menuChoice;

			do {
				System.out.println("Press 1 for Normal User");
				System.out.println("Press 2 for Premium User");
				System.out.print("Please select in which type you want to enter :- ");
				menuChoice=userObj.nextInt();

				switch(menuChoice) {
					case 1:
						NormalUsers user1=	NormalUsers.getClassObject();
						int flagValue=0;
						int user1Choice;
						int paymentChoice = 0;
						do {
							System.out.println("------------------------------------------------");
							System.out.println("Hello user, Please select what you want to do - ");
							System.out.println("Press 1 for Ordering Products");
							System.out.println("Press 2 for New Offers");
							System.out.println("Press 3 for Cancelling Your Order");
							System.out.println("Press 4 for checking your Payment Status");
							System.out.println("Press 5 to check Premium orders");
							System.out.println("Press 6 for log out");
							user1Choice=userObj.nextInt();
							switch(user1Choice) {

								case 1:
									user1.toPurchaseAProduct();
									System.out.println("You selected a product...");
									System.out.println("---------------------------------------");

									do {
										System.out.println("Please Select any 1 Payment option :- ");
										System.out.println("Press 1 for NetBanking");
										System.out.println("Press 2 for Debit/Credit Cards");
										System.out.println("Press 3 for Pay Throungh UPI Payment");
										System.out.println("Press 4 for Pay Cash on Delivery of Product");
										paymentChoice = userObj.nextInt();
										user1.forDifferentPaymentMethod(paymentChoice);
										toSetPersonalDetails();
										if(user1.selectedPaymentMethods>=ShoppingAppsInterface.minPaymentMethod && paymentChoice<=4) {
											System.out.println("Product is ordered on "+ calender.getTime());		//formatDate.format(  )
											int otpForOrder=0;
											for (int i = 0; i < 4; i++) { 
												int random = getRandomInRange(1, 9); 
												if(i==0) {
													random*=1000;
												}
												else if(i==1) {
													random*=100;
												}
												else if(i==2) {
													random*=10;
												}
												otpForOrder+=random;  
											}
											System.out.println("Your OTP for Delivery verification is "+otpForOrder);

											calender.add(Calendar.DAY_OF_MONTH, 5);
											System.out.println("Your order will reach to you before "+formatDate.format(calender.getTime()));

											System.out.println("Please Do not share your OTP with anyone.");
											calender.add(Calendar.DAY_OF_MONTH, -5);
											break;
										}
										else {
											System.out.println("Please complete payment before further processes");
											user1.noOfProductsOrdered=0;
										}
									}while(paymentChoice<=4);

									break;
								case 2:
									user1.toCheckNewOffers();
									break;

								case 3:
									user1.forCancelingOrderedProduct();
									break;
								case 4:
									user1.toCheckPaymentStatus();
									break;
								case 5:
									System.out.println("You are not aplicable for Additional Features that are only Available for premium users");
									user1.toSelectPremiumProducts();
									break;
								case 6:
									System.out.println("Thank you for using.... you are Sucessfully logged out");
									flagValue=1;
									break;
								default:
									if(user1Choice>6) {
										System.out.println("You Entered incorrect details please try again.");
										break;
									}
							}
							if(flagValue==1) {
								break;
							}


						}while(user1Choice<=6);
						System.out.println("----------------------------------------------------");




						break;
					case 2:
						PremiumUsers user=PremiumUsers.getClassObject();
						int flagsValue=0;
						int userChoice;
						do {
							System.out.println("----------------------------------------------------------");
							System.out.println("Hello Premium user, Please select what you want to do - ");
							System.out.println("Press 1 for Ordering Products");
							System.out.println("Press 2 for New Offers");
							System.out.println("Press 3 for Cancelling Your Order");
							System.out.println("Press 4 for checking your Payment Status");
							System.out.println("Press 5 for selecting premium Product orders");
							System.out.println("Press 6 for log out");
							userChoice=userObj.nextInt();
							switch(userChoice) {

								case 1:
									//	int paymentChoice;
									user.toPurchaseAProduct();
									System.out.println("You selected a product...");
									System.out.println("---------------------------------------");
									do {
										System.out.println("Please Select any 1 Payment option :- ");
										System.out.println("Press 1 for NetBanking");
										System.out.println("Press 2 for Debit/Credit Cards");
										System.out.println("Press 3 for Pay Throungh UPI Payment");
										System.out.println("Press 4 for Pay Cash on Delivery of Product");
										paymentChoice = userObj.nextInt();
										user.forDifferentPaymentMethod(paymentChoice);
										toSetPersonalDetails();
										if(user.selectedPaymentMethods>=ShoppingAppsInterface.minPaymentMethod) {
											System.out.println("Product is ordered on "+ calender.getTime());
											int otpForOrder=0;
											for (int i = 0; i < 4; i++) { 
												int random = getRandomInRange(1, 9); 
												if(i==0) {
													random*=1000;
												}
												else if(i==1) {
													random*=100;
												}
												else if(i==2) {
													random*=10;
												}
												otpForOrder+=random;  
											}

											System.out.println("You OTP for Delivery verification is "+otpForOrder);
											calender.add(Calendar.DAY_OF_MONTH, 5);
											System.out.println("Your order will reach to you before "+formatDate.format(calender.getTime()));

											System.out.println("Please Do not share your OTP with anyone.");
											calender.add(Calendar.DAY_OF_MONTH, -5);
											break;

										}
										else {
											System.out.println("Please complete payment before further processes");
											user.noOfProductsOrdered=0;
											break;
										}
									}while(paymentChoice<=4);

									break;
								case 2:
									user.toCheckNewOffers();
									break;

								case 3:
									user.forCancelingOrderedProduct();
									break;
								case 4:
									user.toCheckPaymentStatus();
									break;
								case 5:
									user.toSelectPremiumProducts();
									System.out.println("You selected Premium products...");
									System.out.println("----------------------------------------");
									int paymentsChoice;
									do {
										System.out.println("Please Select any 1 Payment option :- ");
										System.out.println("Press 1 for NetBanking");
										System.out.println("Press 2 for Debit/Credit Cards");
										System.out.println("Press 3 for Pay Throungh UPI Payment");
										System.out.println("Press 4 for Pay Cash on Delivery of Product");
										paymentsChoice = userObj.nextInt();
										user.forDifferentPaymentMethod(paymentsChoice);
										toSetPersonalDetails();
										if(user.selectedPaymentMethods>=1) {
											System.out.println("You ordered Premium product from Premium User Account on "+ calender.getTime());

											int otpForOrder=0;
											for (int i = 0; i < 4; i++) { 
												int random = getRandomInRange(1, 9); 
												if(i==0) {
													random*=1000;
												}
												else if(i==1) {
													random*=100;
												}
												else if(i==2) {
													random*=10;
												}
												otpForOrder+=random;  
											}

											System.out.println("You OTP for Delivery verification is "+otpForOrder);
											calender.add(Calendar.DAY_OF_MONTH, 5);
											System.out.println("Your order will reach to you before "+formatDate.format(calender.getTime()));

											System.out.println("Please Do not share your OTP with anyone.");
											calender.add(Calendar.DAY_OF_MONTH, -5);
											break;
										}
										else {
											System.out.println("You haven't ordered any product or You entered incorrect details");
											user.noOfProductsOrdered=0;
											break;
										}
									}while(paymentsChoice<=4);
									break;
								case 6:
									System.out.println("Thank you for using..... You are sucessfully logged out");
									flagsValue=1;
									break;
								default:
									if(userChoice>5) {
										System.out.println("You Entered incorrect details please try again.");
										break;
									}
							}
							if(flagsValue==1) {
								break;
							}

						}while(userChoice<=6);
						System.out.println("----------------------------------------------------");
						break;

					default:
						if(menuChoice>=3) {
							System.out.println("You Entered incorrect details please try again.");
							break;
						}
				}
			}while(menuChoice<=2);


		}
		catch(Exception exptionObj) {
			System.out.println(exptionObj.toString());

		}
		finally {
			userObj.close();

		}

	}

	static void toSetPersonalDetails() {
		System.out.println("Please Enter your personal details - ");
		System.out.print("Enter your name :- ");
		userObj.nextLine();
		String name=userObj.nextLine();
		System.out.print("Enter your gender(Male as M/Female as F) :- ");
		String genderOfPerson=userObj.next();
		char gender=genderOfPerson.charAt(0);
		System.out.print("Enter your mobile number :- ");
		long mobileNum=userObj.nextLong();
		System.out.println();
		System.out.println("Please Enter Address Details - ");
		System.out.print("Enter Door Number :- ");
		int doorNumber=userObj.nextInt();
		System.out.print("Enter Street Name :- ");
		userObj.nextLine();
		String streetName=userObj.nextLine();
		System.out.print("Enter Your City Name :- ");
		String cityName=userObj.next();
		System.out.print("Enter Your State Name :- ");
		String stateName=userObj.next();
		System.out.print("Enter Your Pincode :- ");
		int pincode=userObj.nextInt();
		newAddress=new Address(doorNumber, streetName, cityName, stateName, pincode);
		personObj.toSetPersonalData(name, gender,(long) mobileNum, newAddress);
		System.out.print("Your order will reach to you Mr./Mrs. "+personObj.getName()+" on Address ");
		personObj.getAddressDetails();
	}
}

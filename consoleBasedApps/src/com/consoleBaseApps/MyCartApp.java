package com.consoleBaseApps;

public abstract class MyCartApp implements ShoppingAppsInterface {
	int noOfProductsOrdered=0;
	int selectedPaymentMethods = 0;
	public void toPurchaseAProduct() {
		if(isOrdered) {
			noOfProductsOrdered++;
		}
	}

	public void forCancelingOrderedProduct() {
		if(noOfProductsOrdered>0) {
			noOfProductsOrdered-=1;
			System.out.println("Your ordered product is cancelled and if payment is done will be refunded within 24 hours.");
		}
		else {
			System.out.println("You haven't added any product for order");
		}
	}

	public void forDifferentPaymentMethod(int paymentChoice) {
		do {
			switch(paymentChoice) {
			case 1:
				byNetBanking();
				selectedPaymentMethods++;
				break;
			case 2:
				byDebitCards();
				selectedPaymentMethods++;
				break;
			case 3:
				byUPIMethods();
				selectedPaymentMethods++;
				break;
			case 4:
				byCashOnDelivery();
				selectedPaymentMethods++;
				break;
			default:
				if(paymentChoice>4) {
					System.out.println("You selected incorrect method for payment please try again");
					//	break;
				}
				break;
			}
			break;
		}while(paymentChoice<=4);
	}
	void byNetBanking() {
		System.out.println("You selected online NetBanking Method for payment.");
	};
	void byDebitCards() {
		System.out.println("You selected Debit/Credit card Method for payment.");
	}
	void byUPIMethods() {
		System.out.println("You selected UPI Method for payment.");
	}
	void byCashOnDelivery() {
		System.out.println("You selected Cash on Delivery Method for payment.");
	}

	abstract void toSelectPremiumProducts();
}


package com.consoleBaseApps;

public class NormalUsers extends MyCartApp {
	static NormalUsers user1=new NormalUsers();

	public static NormalUsers getClassObject() {

		return user1;
	}
	private NormalUsers() {	}

	public void toCheckPaymentStatus() {
		if(noOfProductsOrdered>=1 && selectedPaymentMethods>=minPaymentMethod) {
			System.out.println("You have paid for "+noOfProductsOrdered +" products");
		}
		else {
			super.toCheckPaymentStatus();
		}
	}
	@Override
	void toSelectPremiumProducts() {
		System.out.println("Premium section not Available for Normal Users please upgrade account to Premium User");
	}

	@Override
	public void toCheckNewOffers() {
		System.out.println("You selected to see new offers for ordering product");
	}

}

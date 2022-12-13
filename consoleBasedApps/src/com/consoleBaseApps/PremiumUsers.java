package com.consoleBaseApps;

public class PremiumUsers extends MyCartApp {
	public static PremiumUsers user=new PremiumUsers();

	public static PremiumUsers getClassObject() {

		return user;
	}
	private PremiumUsers() {	}

	public void toCheckPaymentStatus() {
		if(noOfProductsOrdered>=1 && selectedPaymentMethods>=minPaymentMethod) {
			System.out.println("You have paid for "+noOfProductsOrdered);
		}
		else {
			super.toCheckPaymentStatus();
		}
	}

	@Override
	void toSelectPremiumProducts() {
		user.toPurchaseAProduct();

	}

	@Override
	public void toCheckNewOffers() {
		System.out.println("You selected to see new offers for ordering product");
	}

}

package com.consoleBaseApps;

public interface ShoppingAppsInterface {
	int maxCartLimit=5;					//public static final
	int minPaymentMethod=1;
	boolean isOrdered=true;

	void toPurchaseAProduct();				//public abstract
	void forCancelingOrderedProduct();
	void forDifferentPaymentMethod(int paymentChoice);
	void toCheckNewOffers();

	default void toCheckPaymentStatus() {			//default method
		System.out.println("Items not ordered yet please order your products first.");
	}	
}

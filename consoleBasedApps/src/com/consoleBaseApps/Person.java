package com.consoleBaseApps;

public class Person {
	private String name;
	private char gender;
	private long mobileNumber;
	private Address address;

	//void toSetPersonalData(String name,char gender,long mobileNumber,int doorNumber,String streetName,String cityName,String stateName,int pincode) {
	void toSetPersonalData(String name,char gender,long mobileNumber,Address obj) {

		setName(name);
		setGender(gender);
		setMobileNumber(mobileNumber);
		this.address=obj;
	}

	void getAddressDetails() {
		System.out.println(address.getDoorNumber()+","+address.getStreetName()+","+address.getCityName()+","+address.getStateName()+","+address.getPincode());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}

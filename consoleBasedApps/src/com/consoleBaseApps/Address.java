package com.consoleBaseApps;

public class Address {

	private int doorNumber;
	private String streetName;
	private String cityName;
	private String stateName;
	private int pincode;

	Address(int doorNumber,String streetName,String cityName,String stateName,int pincode){
		setDoorNumber(doorNumber);
		setStreetName(streetName);
		setCityName(cityName);
		setStateName(stateName);
		setPincode(pincode);
	}
	public int getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
/*
this.doorNumber=doorNumber;
this.streetName=streetName;
this.cityName=cityName;
this.stateName=stateName;
this.pincode=pincode;
 */
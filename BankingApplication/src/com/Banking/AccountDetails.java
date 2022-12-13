package com.Banking;


public class AccountDetails {

	private String accoutNum;
	private String nameOfAccountOwner;
	private int Amount;
	public String getAccoutNum() {
		return accoutNum;
	}
	public void setAccoutNum(String accoutNum) {
		this.accoutNum = accoutNum;
	}
	public String getNameOfAccountOwner() {
		return nameOfAccountOwner;
	}
	public void setNameOfAccountOwner(String nameOfAccountOwner) {
		this.nameOfAccountOwner = nameOfAccountOwner;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}

	public AccountDetails() {}

	public AccountDetails(String accoutNum, String nameOfAccountOwner, int amount) {
		this.accoutNum = accoutNum;
		this.nameOfAccountOwner = nameOfAccountOwner;
		Amount = amount;
	}
	public AccountDetails createNewAccount(String codeOfAccount, String nameOfOwner) {
		AccountDetails obj = new AccountDetails();
		this.accoutNum=obj.accoutNum=codeOfAccount;
		this.nameOfAccountOwner=obj.nameOfAccountOwner=nameOfOwner;
		this.Amount=obj.Amount=0;
		return obj;
	}

	public void depositAmountInAccount(int amountToBeDeposited) {
		this.Amount += amountToBeDeposited;
		System.out.println("Amount Deposited Sucessfully");
	}

	public void withdrawAmountFromAccount(int amountToBeWithdrawn) {
		if(amountToBeWithdrawn > Amount) {
			System.out.println("You haven't sufficient balance in your Account to complete transaction");
		}
		else {
			this.Amount -= amountToBeWithdrawn;
			System.out.println("Amount Withdrawn Successfully");
		}
	}

	public void showBalanceOfAccount(AccountDetails accountDetails) {
		System.out.println(this.nameOfAccountOwner +"  "+ this.Amount);
	}
	@Override
	public String toString() {
		return "AccountDetails [accoutNum=" + accoutNum + ", nameOfAccountOwner=" + nameOfAccountOwner + ", Amount="
				+ Amount + "]";
	}

}

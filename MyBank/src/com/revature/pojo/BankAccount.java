package com.revature.pojo;

public class BankAccount {
	
	private int accountId; 

	private int balance;
	

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	} 
	
	//Function for Depositing money
	public int deposit(int amount) {
			if (amount != 0) {
				 balance = balance + amount;
				
			}
			return balance;
		}
		
		//Function for Withdrawing money
	public int withdraw(int amount) {
			if (amount != 0) {
				balance = balance - amount;
				
			}
			return balance;
		}
	

	public BankAccount (int balance) {
		super();
		
		this.balance = balance;
	}

	

	

	

}

package com.revature.pojo;

public class BankAccount {
	
	private int accountId; 

	private int balance;
	
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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
//	public int deposit(int amount) {
//			if (amount != 0) {
//				 balance = balance + amount;
//				
//			}
//			user.setBalance(balance);
//			return balance;
//		}
//		
//		//Function for Withdrawing money
//	public int withdraw(int amount) {
//			if (amount != 0) {
//				balance = balance - amount;
//				
//			}
//			user.setBalance(balance);
//			return balance;
//		}
	



	public BankAccount(int userId, int balance) {
		
		this.userId = userId;
		this.balance = balance;
	}

	public BankAccount() {
		super();
	}

	public BankAccount(int accountId, int balance, int userId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.userId = userId;
	}
	
	
	
	

	

	

	

}

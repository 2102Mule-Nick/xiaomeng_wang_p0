package com.revature.pojo;

public class BankAccount {
	
	private String accountId; 

	private int balance;
	

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
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
	

	public BankAccount () {
		super();
		
	}
	
	public BankAccount (String accountId) {
		super();
		
		this.accountId = accountId;
	}
	
	public BankAccount (int balance) {
		super();
		
		this.balance = balance;
	}

	public BankAccount(String accountId, int balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}
	
	

	

	

	

}

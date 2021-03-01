package com.revature.pojo;

public class BankAccount {
	
	private int accountId; // default value = 0

	private float total; // default value = 0.0

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public BankAccount(int accountId, float total) {
		super();
		this.accountId = accountId;
		this.total = total;
	}

	

}

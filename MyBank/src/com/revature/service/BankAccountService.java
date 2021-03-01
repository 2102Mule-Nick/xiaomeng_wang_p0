package com.revature.service;

public interface BankAccountService {
	
	public void withdraw(int accoundId, float total);
	
	public void deposite(int accoundId, float total);
	
	public float checkBalance();

}

package com.revature.service;

public interface BankAccountService {
	
	public void withdraw(int accound ,int amount);
	
	public void deposite(int accound ,int amount);
	
	public int checkBalance();

}

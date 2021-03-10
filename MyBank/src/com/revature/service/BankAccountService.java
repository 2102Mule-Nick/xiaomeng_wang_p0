package com.revature.service;


import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public interface BankAccountService {
	
	public int withdraw(User user, int amount);
	
	public int deposite(User user, int amount);
	
	public int checkBalance(User user);
	
	public BankAccount createBankAccount(BankAccount bankAccount);
	
	

}

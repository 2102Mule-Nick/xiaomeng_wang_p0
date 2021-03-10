package com.revature.dao;

import java.sql.SQLException;

import com.revature.pojo.BankAccount;

public interface BankAccountDao {
	
	public BankAccount createBankAccount(BankAccount bankAccount) throws SQLException;
	
	public BankAccount getBankAccountById(int id);
	
	public void deleteBankAccountt(int id);
	
	public void updateBankAccount(BankAccount bankAccount);

	public BankAccount getBankAccountByUserID(int userID) throws SQLException ;

	public void updateBalanceByAccountID(int accountId, int balance) throws SQLException;
	

}

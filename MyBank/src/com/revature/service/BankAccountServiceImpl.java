package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.BankAccountDao;
import com.revature.dao.UserDao;
import com.revature.exception.UserNotFound;
import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public class BankAccountServiceImpl implements BankAccountService {

	BankAccountDao dao;
	

	@Override
	public int withdraw(User user, int amount) {
		// TODO Auto-generated method stub
		BankAccount account = null;
		try {
			account = dao.getBankAccountByUserID(user.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int balance = account.getBalance();
		if (amount != 0 && balance > amount) {
			balance -= amount;
			try {
				dao.updateBalanceByAccountID(account.getAccountId(), balance);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return balance;
	}

	@Override
	public int deposite(User user, int amount){
		BankAccount account;
		try {
			account = dao.getBankAccountByUserID(user.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		int balance = account.getBalance();;
		if (amount > 0) {
			balance += amount;
			try {
				dao.updateBalanceByAccountID(account.getAccountId(), balance);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return balance;
	}

	@Override
	public int checkBalance(User user) {
		BankAccount bankAccount = null;
		try {
			bankAccount = dao.getBankAccountByUserID(user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int balance = bankAccount.getBalance();
		
		return balance;
	}

	public BankAccountServiceImpl(BankAccountDao bankDao) {
		super();
		this.dao = bankDao;
	}

	@Override
	public BankAccount createBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		try {
			dao.createBankAccount(bankAccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	
}

package com.revature.service;

public class BankAccountServiceImpl implements BankAccountService {

	float total = 0.0f;
	@Override
	public float checkBalance() {
		// TODO Auto-generated method stub
		return total;
	}

	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
		total = total+ amount;
	}

	@Override
	public void deposite(float amount) {
		// TODO Auto-generated method stub
		total = total -amount;
		
	}

}

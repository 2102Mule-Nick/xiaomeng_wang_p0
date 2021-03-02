package com.revature.ui;

import java.util.Scanner;

public class WithdrawMenu implements Menu{
	
	private Scanner scan;

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		System.out.println("Please Enter the amount want to withdraw:");
		int amount = scan.nextInt();
		
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

}

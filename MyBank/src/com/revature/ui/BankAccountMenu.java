package com.revature.ui;

import java.util.Scanner;

import com.revature.pojo.BankAccount;

public class BankAccountMenu implements Menu{
	
	//private Menu nextMenu;
	
	//private Menu withdrawMenu;

	//private Menu depositMenu;

	private Scanner scan;

	private BankAccount bankAccount;
	
	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		//BankAccount accoundId = new BankAccount(accountId);
		
		System.out.println("**** Welcome to the BankAccount ****");
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		BankAccount bankAccount = new BankAccount();
		
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scan.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			//Case 'A' allows the user to check their account balance
			case 'A':
				System.out.println("====================================");
				System.out.println("Balance = $" + bankAccount.getBalance());
				System.out.println("====================================");
				System.out.println();
				break;
			//Case 'B' allows the user to deposit money into their account using the 'deposit' function
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scan.nextInt();
				bankAccount.deposit(amount);
				System.out.println();
				break;
			//Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scan.nextInt();
				bankAccount.withdraw(amount2);
				System.out.println();
				break;
			
			//Case 'F' exits the user from their account
			case 'F':
				System.out.println("====================================");
				break;
			//The default case let's the user know that they entered an invalid character and how to enter a valid one
			default:
				System.out.println("Error: invalid option. Please enter A, B, C access services.");
				break;
			}
		} while(option != 'F');
		System.out.println("Thank you for banking with us!");
	}

		
		
		
		//System.out.println("Please enter a AccountID:");
		
		//int accountId = scan.nextInt();
		
		//BankAccount bankAccount = new BankAccount(accountId);
		
//		System.out.println("Would you like to withdraw or deposit?");
//		
//		String answer = scan.nextLine();
//		
//		if ("withdraw".equals(answer)) {
//			nextMenu = withdrawMenu;
//		} else if ("deposit".equals(answer)) {
//			nextMenu = depositMenu;
//		} else {
//			System.out.println("invalid input");
//			//redirect user to same we menu
//			nextMenu = this;
//		}
		
	

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		this.scan =scan;
		
	}
	
	public BankAccountMenu() {
		super();
	}

	
	
	

}

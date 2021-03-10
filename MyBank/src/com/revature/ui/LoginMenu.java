package com.revature.ui;

import java.util.Scanner;

import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;
import com.revature.service.AuthService;

public class LoginMenu implements Menu{
	
	private AuthService authService;
	
	private Menu nextMenu;
	
	private BankAccountMenu bankAccountMenu;

	private Scanner scan;
	

	public Scanner getScanner() {
		return scan;
	}

	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public AuthService getUserService() {
		return authService;
	}

	public void setUserService(AuthService userService) {
		this.authService = userService;
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		System.out.println("Please Enter Username");
		String username = scan.nextLine();
		System.out.println("Please Enter Password");
		String password = scan.nextLine();
		
		User user = new User(username, password);
		
		try {
			authService.authenticateUser(user);
			System.out.println("Login successful");
			bankAccountMenu.setCurrentUser(user);
			nextMenu = bankAccountMenu;
			
			//throw new Error();
		} catch (UserNotFound e) {
			System.out.println("Username does not exist.  Please register an account.");
		} catch (InvalidPassword e) {
			System.out.println("Authentication error, check username/password");
		} catch (Exception e) {
			System.out.println("Sorry, something went wrong. Please try again later.");
			e.printStackTrace();
		} //finally {
			//System.out.println("Login Process Ended");
		//}
		
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginMenu() {
		super();
	}

	public LoginMenu(AuthService authService, BankAccountMenu bankAccountMenu) {
		super();
		this.authService = authService;
		this.bankAccountMenu = bankAccountMenu;
	}

	


}

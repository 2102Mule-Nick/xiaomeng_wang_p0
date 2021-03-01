package com.revature.ui;

import java.util.Scanner;

import com.revature.exception.UserNameTaken;
import com.revature.pojo.User;
import com.revature.service.AuthService;

public class RegistrationMenu implements Menu{
	
	private Menu welcomeMenu;

	private Menu nextMenu;
	
	private Scanner scan;

	private AuthService authService;


	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		User user = new User();
		System.out.println("Please enter a new username:");
		user.setUsername(scan.nextLine());
		System.out.println("Please enter a new password:");
		user.setPassword(scan.nextLine());
		if (!authService.existingUser(user)) {
			try {
				authService.registerUser(user);
				nextMenu = null;
			} catch (UserNameTaken e) {
				System.out.println("Username taken, please try again");
				nextMenu = welcomeMenu;
			}
		} else {
			System.out.println("Username taken, please try again");
			nextMenu = welcomeMenu;
		}
		
	}

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
		this.scan = scan;
		
	}
	
	public RegistrationMenu() {
		super();
	}

	public RegistrationMenu(AuthService authService, Menu welcomeMenu) {
		super();
		this.authService = authService;
		this.welcomeMenu = welcomeMenu;
	}

	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}

	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}


}
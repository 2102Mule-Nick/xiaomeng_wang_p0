package com.revature;

import java.util.Scanner;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoKryo;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.ui.BankAccountMenu;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.WelcomeMenu;
import com.revature.ui.WithdrawMenu;

public class Driver {
	
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoKryo();
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu register = new RegistrationMenu();
		
		Menu bankAccountMenu = new BankAccountMenu();
//		Menu withdrawMenu = new WithdrawMenu();
//		Menu depositMenu = new DepositMenu();
		
		Menu login = new LoginMenu(authService, bankAccountMenu);
		
		Menu welcomeMenu = new WelcomeMenu(login, register);
		
		((RegistrationMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistrationMenu)register).setAuthService(authService);
		
		//((WithdrawnMenu)withdraw).setWelcomeMenu(welcomeMenu);
		
		login.setScanner(scan);
		
		register.setScanner(scan);
		
		welcomeMenu.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
			
		} while (nextMenu != null);
		

		
	}

}

package com.revature;

import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoPostgres;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoPostgres;
import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;
import com.revature.service.BankAccountService;
import com.revature.service.BankAccountServiceImpl;
import com.revature.ui.BankAccountMenu;
import com.revature.ui.LoginMenu;
import com.revature.ui.Menu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.WelcomeMenu;

public class Driver {
	
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//UserDao userDao = new UserDaoKryo();
		
		UserDao userDao = new UserDaoPostgres();
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		
		
		BankAccountDao bankDao = new BankAccountDaoPostgres();
		
		BankAccountService bankService = new BankAccountServiceImpl(bankDao);
		
		BankAccountMenu bankAccountMenu = new BankAccountMenu(bankService);
		
		Menu login = new LoginMenu(authService, bankAccountMenu);
		
		RegistrationMenu register = new RegistrationMenu(authService, bankService);
	
		Menu welcomeMenu = new WelcomeMenu(login, register);
		
		register.setWelcomeMenu(welcomeMenu);
	
		
		
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

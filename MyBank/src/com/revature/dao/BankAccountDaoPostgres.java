package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.pojo.BankAccount;
import com.revature.util.ConnectionFactoryPostgres;

public class BankAccountDaoPostgres implements BankAccountDao {
	
	Logger log = Logger.getRootLogger();
	
	static final String INSERT_SMT = "insert into bank (user_id, balance) values(?, ?)";
	static final String UPDATE_BALANCE_BY_ID = "update bank set balance = ? where user_id =? ";



	@Override
	public BankAccount createBankAccount(BankAccount bankAccount) throws SQLException {
		Connection conn = ConnectionFactoryPostgres.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(INSERT_SMT, Statement.RETURN_GENERATED_KEYS);
		  pstmt.setInt(1, bankAccount.getUserId()); 
		  pstmt.setFloat(2, bankAccount.getBalance());
		  pstmt.executeUpdate(); 
		  
		  //grab generated cart_id
		  ResultSet rs = pstmt.getGeneratedKeys();
		  rs.next();
		  bankAccount.setAccountId((int)rs.getLong(1));
		 
		return bankAccount;
	}

	@Override
	public BankAccount getBankAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBankAccountt(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateBalanceByAccountID(int accountID, int balance) throws SQLException {
		Connection conn = ConnectionFactoryPostgres.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(UPDATE_BALANCE_BY_ID);
		  pstmt.setInt(1, balance); 
		  pstmt.setInt(2, accountID);
		  pstmt.executeUpdate();  
		 
		  ResultSet rs = pstmt.getGeneratedKeys();
		  rs.next();
	}

	@Override
	public BankAccount getBankAccountByUserID(int userId) throws SQLException {
		BankAccount bankAccount = null;
		Connection conn = ConnectionFactoryPostgres.getConnection();
		String sql = "select * from bank where user_id = '" + userId + "'";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			//log.info("User found in DB");
			bankAccount = new BankAccount();
			bankAccount.setAccountId(rs.getInt("bank_id"));
			bankAccount.setUserId(rs.getInt("user_id"));
			bankAccount.setBalance(rs.getInt("user_id"));
		}
		
		return bankAccount;
	}

	
	

}

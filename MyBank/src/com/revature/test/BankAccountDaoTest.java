package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.dao.BankAccountDaoPostgres;
import com.revature.pojo.BankAccount;
import com.revature.util.ConnectionFactoryPostgres;

@ExtendWith(MockitoExtension.class)
class BankAccountDaoTest {

	@Mock
	private Connection connection;
	
	BankAccountDaoPostgres daoPostgres;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		daoPostgres = new BankAccountDaoPostgres();
		
		PreparedStatement pstmt = ConnectionFactoryPostgres.getConnection().prepareStatement("delete from bank where user_id = 4");
		
		pstmt.executeUpdate();
		
	}
	@Test
	void creatBankAccountTest() {
		
				String sql = "insert into bank (user_id, balance) values(?, ?)";
				
				Connection realConnection = ConnectionFactoryPostgres.getConnection();
				
				System.out.println(realConnection);
				
				PreparedStatement realStmt = realConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				
				PreparedStatement spy = Mockito.spy(realStmt);
				
				System.out.println("Spy" + spy);
				
				System.out.println("Conn Mock" + connection);

				when(connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)).thenReturn(spy);
				
				daoPostgres.setConn(connection);
				
				
				BankAccount bankAccount = new BankAccount();
				
				bankAccount.setBalance(0);
				
				bankAccount.getUserId();
				
				
				daoPostgres.createBankAccount(bankAccount);
				
				verify(spy).setInt(1, bankAccount.getUserId());
				
				verify(spy).setFloat(2, bankAccount.getBalance());
				
				verify(spy).executeUpdate();
		
				PreparedStatement checkStmt = ConnectionFactoryPostgres.getConnection().prepareStatement("select * from cart where user_id = 30");
				
				ResultSet rs = checkStmt.executeQuery();
				
				assertTrue(rs.next());
				
				
			

	private PreparedStatement verify(PreparedStatement spy) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

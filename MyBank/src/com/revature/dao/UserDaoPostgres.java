package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.exception.UserNameTaken;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactoryPostgres;

public class UserDaoPostgres implements UserDao {
	
	Logger log = Logger.getRootLogger();

	@Override
	public void createUser(User user) throws UserNameTaken {
		
		log.trace("UserDaoPostgres.createUser method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "insert into user_acc (username, pass_word) values ('" + user.getUsername() + "', '" +user.getPassword() + "')";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}
		
		User user = null;
		
		String url = "jdbc:postgresql://" + System.getenv("BANK_DB_URL") + ":5432/" +"postgres" + "?";
		
		try (Connection conn = DriverManager.getConnection(url, System.getenv("BANK_DB_USERNAME"), System.getenv("BANK_DB_PASSWORD"));){
			
			//conn.setSchema(schema) default is public;
			
			String sql = "select * from user_acc where username = '" + username + "'" ;
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				log.info("User found in DB");
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pass_word"));
				user.setId(rs.getInt("user_id"));
			}
			
			
		} catch (SQLException e) {
			log.error("failur to connet to database");
			
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user,String new_password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		String sql = "update user_acc set pass_word = ? WHERE username = ?";
		
		conn = ConnectionFactoryPostgres.getConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, new_password);
			stmt.setString(2, user.getUsername());
			stmt.execute();
			log.info("User updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Unsuccessful update");
		}
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		log.trace("UserDaoPostgres.createUser method called");
		
		Connection conn = ConnectionFactoryPostgres.getConnection();
		
		String sql = "delete from user_acc " + 
					  "where username = '" + user.getUsername() + "' and pass_word = '" +user.getPassword() + "'";
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

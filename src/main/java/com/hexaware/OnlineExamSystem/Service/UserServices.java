package com.hexaware.OnlineExamSystem.Service;

import java.util.Scanner;


import com.hexaware.OnlineExamSystem.Dao.IUserService;
import com.hexaware.OnlineExamSystem.Model.User;
import com.hexaware.OnlineExamSystem.com.hexaware.OnlineExamSystemHibernate.App;


public class UserServices {
	Scanner sc = new Scanner(System.in);
	
	// sign up
	public void signUp(String role) {
		User user = new User();
		IUserService ius = new IUserService();
		
		System.out.println("Enter username: ");
		String username = sc.next();
		sc.nextLine();
		System.out.println("Enter email: ");
		String email = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		user.setName(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		ius.userSignUp(user);
		
	}
	
	//sign in
	public User signIn() {
		User user = new User();
		IUserService ius = new IUserService();
		
		sc.nextLine();
		System.out.println("Enter username: ");
		String username = sc.nextLine();
		System.out.println("Enter email: ");
		String email = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		user.setName(username);
		user.setEmail(email);
		user.setPassword(password);
		ius.userSignIn(user);
		return user;
		
	}
	
	
	//modify email
	public void modifyEmail(User user) {
		IUserService ius = new IUserService();
		
		System.out.println("Enter new email: ");
		String newEmail = sc.next();
		
		ius.userChangeEmail(user, newEmail);
		
	}
	
	
	//modify password
	public void modifyPassword(User user) {
		IUserService ius = new IUserService();
		
		System.out.println("Enter current Password: ");
		String currentPassword = sc.next();
		System.out.println("Enter new Password: ");
		String newPassword = sc.next();
		
		ius.userChangePassword(user, currentPassword, newPassword);
		
	}
	
	
	//user logout
	public void logOut(User user) {
		IUserService ius = new IUserService();
		
		ius.logout(user);
	}
	
}

package com.hexaware.OnlineExamSystem.Service;

import java.util.Scanner;

import com.hexaware.OnlineExamSystem.Dao.IAdminService;
import com.hexaware.OnlineExamSystem.Model.User;


public class AdminServices {
	Scanner sc = new Scanner(System.in);
	
	//view all users
	public void viewAllUsers() {
		IAdminService ias = new IAdminService();
		
		System.out.println("All Users....");
		ias.viewUsers();
	}
	
	
	//add new users
	public void addUser() {
		User user = new User();
		IAdminService ias = new IAdminService();
		
		System.out.println("Enter no. of users to be added: ");
		int totalNewUsers = sc.nextInt();
		for(int i=0; i<totalNewUsers; i++) {
			System.out.println("Enter Username: ");
			String username = sc.next();
			System.out.println("Enter Email: ");
			String email = sc.next();
			System.out.println("Enter Password: ");
			String password = sc.next();
			System.out.println("Enter Role");
			String role = sc.next();
			
			user.setName(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			ias.adminAddUser(user);
		}	
	}
	
	
	// remove user
	public void removeUser() {
		User user = new User();
		IAdminService ias = new IAdminService();
		
		ias.viewUsers();
		System.out.println("Enter the user id to remove: ");
		int userId = sc.nextInt();
		ias.adminRemoveUser(userId);
	}
	
	//modify user details
	public void modifyUser() {
		User user = new User();
		IAdminService ias = new IAdminService();
		
		ias.viewUsers();
		System.out.println("Enter the user id of the user to modify details: ");
		int userId = sc.nextInt();
		System.out.println("Enter new name: ");
		String name = sc.next();
		System.out.println("Enter new email: ");
		String email = sc.next();
		System.out.println("Enter new password: ");
		String password = sc.next();
		
//		user.setUserId(userId);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		ias.adminModifyUsers(user, userId);
	}
	
	//admin logout
	public void logoutAdmin(User user) {
		IAdminService ias = new IAdminService();
		ias.logout(user);
	}

	
}

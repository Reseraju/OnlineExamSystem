package com.hexaware.OnlineExamSystem.Service;

import java.util.Scanner;

import com.hexaware.OnlineExamSystem.Dao.IAdminService;
import com.hexaware.OnlineExamSystem.Model.Question;
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
		String name = sc.nextLine();
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

	// addQuestion
	public void addQuestion() {
		Question ques =new Question();
		IAdminService ias = new IAdminService();
		
		System.out.println("Enter the Question(Text) : ");
		String qText =sc.nextLine();
		System.out.println("Option A: ");
		String optionA = sc.nextLine();
		System.out.println("Option B: ");
		String optionB = sc.nextLine();
		System.out.println("Option C: ");
		String optionC = sc.nextLine();
		System.out.println("Option D: ");
		String optionD = sc.nextLine();
		System.out.println("Enter correct answer: ");
		String correctAnwer = sc.nextLine();
		
		ques.setqText(qText);
		ques.setOptionA(optionA);
		ques.setOptionB(optionB);
		ques.setOptionC(optionC);
		ques.setOptionD(optionD);
		ques.setCorrectAnswer(correctAnwer);
		ias.adminAddQuestion(ques);
		
	}
	
	//view all questions
	public void viewAllQuestions() {
		IAdminService ias = new IAdminService();
		
		System.out.println("All questions...");
		ias.adminViewQuestions();
	}
	
	//modify question
	public void modifyQuestion() {
		Question ques = new Question();
		IAdminService ias = new IAdminService();
		
		ias.adminViewQuestions();
		System.out.println("Enter the question id of the question to be modified: ");
		int qId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Question: ");
		String qText = sc.nextLine();
		System.out.println("Option A: ");
		String optionA = sc.next();
		System.out.println("Option B: ");
		String optionB = sc.next();
		System.out.println("Option c: ");
		String optionC = sc.next();
		System.out.println("Option D: ");
		String optionD = sc.next();
		System.out.println("Correct answer: ");
		String correctAnswer = sc.next();
		
		ques.setqText(qText);
		ques.setOptionA(optionA);
		ques.setOptionB(optionB);
		ques.setOptionC(optionC);
		ques.setOptionD(optionD);
		ques.setCorrectAnswer(correctAnswer);
		ias.adminModifyQuestion(ques, qId);
	}
	
	//remove question
	public void removeQuestion() {
		Question ques = new Question();
		IAdminService ias = new IAdminService();
		
		ias.adminViewQuestions();
		System.out.println("Enter the question Id to remove");
		int qId = sc.nextInt();
		ias.adminRemoveQuestion(qId);
	}
}

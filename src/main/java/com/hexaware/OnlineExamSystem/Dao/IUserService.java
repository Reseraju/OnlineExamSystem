package com.hexaware.OnlineExamSystem.Dao;



import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hexaware.OnlineExamSystem.Model.Question;
import com.hexaware.OnlineExamSystem.Model.User;
import com.hexaware.OnlineExamSystem.Util.ConnectionUtil;


public class IUserService {
	ConnectionUtil util = new ConnectionUtil();
	Session ses;
	
	public void userSignUp(User user) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		User u = ses.find(User.class, user.getUserId());

		if (u == null) {
			ses.save(user);
			tax.commit();
			System.out.println("User signed Up. Please sign in!");
		} else {
			System.out.println("User already exists");
		}
		ses.close();
	}

	public void userSignIn(User user) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<User> query = ses.createQuery("from User where name=:username and password =:password", User.class);
		query.setParameter("username", user.getName());
		query.setParameter("password", user.getPassword());
		User u = query.uniqueResult();
		
		if (u != null) {
			String pass = u.getPassword();
			if (pass.equals(user.getPassword())) {
				u.setActive(true);
				ses.saveOrUpdate(u);
				tax.commit();
				System.out.println("Welcome " + u.getName() + " !");
			} else {
				System.out.println("Invalid credentials");
			}
		} else {
			System.out.println("Invalid nnn credentials");
		}
		ses.close();
	}

	public void userChangeEmail(User user, String newEmail) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<User> query = ses.createQuery("from User where name=:username and password =:password", User.class);
		query.setParameter("username", user.getName());
		query.setParameter("password", user.getPassword());
		User u = query.uniqueResult();
		
		if(u != null) {
			if(u.isActive()) {
				u.setEmail(newEmail);
				ses.saveOrUpdate(u);
				tax.commit();
				System.out.println("Email Updated!");
			}
			else {
				System.out.println("Please sign in!!");
			}
		}
		else {
			System.out.println("User does not exists!!");
		}
		ses.close();
	}

	public void userChangePassword(User user, String currentPassword, String newPassword) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<User> query = ses.createQuery("from User where name=:username and password =:password", User.class);
		query.setParameter("username", user.getName());
		query.setParameter("password", currentPassword);
		User u = query.uniqueResult();
		
		if(u != null) {
			if(u.isActive()) {
				u.setPassword(newPassword);
				ses.saveOrUpdate(u);
				tax.commit();
				System.out.println("Password Updated!");
			}
			else {
				System.out.println("Please sign in!!");
			}
		}
		else {
			System.out.println("User does not exists!!");
		}
		ses.close();
		
	}
	
	public void userTakeExam(User user) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		List<String> correctAnswers = new ArrayList<>();
		List<String> userAnswers = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		Query<Question> query = ses.createQuery("from Question", Question.class);
		List<Question> qlist = query.getResultList();
		
		for(Question  q : qlist) {
			System.out.println("Question: " + q.getqText());
			System.out.println("Option A: " + q.getOptionA());
			System.out.println("Option B: " + q.getOptionB());
			System.out.println("Option C: " + q.getOptionC());
			System.out.println("Option D: " + q.getOptionD());
			correctAnswers.add(q.getCorrectAnswer());
			
			System.out.print("Enter your answer (A, B, C, or D): ");
	        String userAnswer = sc.nextLine().toUpperCase();
	        userAnswers.add(userAnswer);
	        
	        System.out.println();
		}
		
		System.out.println("Correct Answers:");
	    for (int i = 0; i < qlist.size(); i++) {
	        System.out.println("Question " + (i + 1) + ": Correct Answer = " + correctAnswers.get(i) + ", Your Answer = " + userAnswers.get(i));
	    }
	}
	
	public void logout(User user) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<User> query = ses.createQuery("from User where name=:username and password =:password", User.class);
		query.setParameter("username", user.getName());
		query.setParameter("password", user.getPassword());
		User u = query.uniqueResult();
		
		if(u != null) {
			if(u.isActive()) {
				u.setActive(false);
				ses.saveOrUpdate(u);
				tax.commit();
				System.out.println("Logging Out....👋");
			}
			else {
				System.out.println("User already logged out");
			}
		}
		else {
			System.out.println("User Does not exists");
		}
		ses.close();
	}
}








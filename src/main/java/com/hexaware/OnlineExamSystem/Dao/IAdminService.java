package com.hexaware.OnlineExamSystem.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hexaware.OnlineExamSystem.Model.Question;
import com.hexaware.OnlineExamSystem.Model.User;
import com.hexaware.OnlineExamSystem.Util.ConnectionUtil;

public class IAdminService {
	
	ConnectionUtil util = new ConnectionUtil();
	Session ses;
	
	// view all users
	public void viewUsers() {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<User> query = ses.createQuery("from User");
		List<User> ulist = query.list();
		
		for(User u : ulist) {
			System.out.println(u.toString());
		}
		ses.close();
	}
	
	// add users
	public void adminAddUser(User user) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();

		User u = ses.find(User.class, user.getUserId());

		if (u == null) {
			ses.save(user);
			tax.commit();
			System.out.println("User signed Up.");
		} else {
			System.out.println("User already exists");
		}
		ses.close();
	}
	
	// remove user
	public void adminRemoveUser(int userId) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<User> query = ses.createQuery("from User where UserId=:userId");
		query.setParameter("userId", userId);
		
		User u = query.uniqueResult();
		String name = u.getName();
		
		ses.delete(u);
		tax.commit();
		System.out.println("User named " + name + " has been removed !!");
		ses.close();
	}
	
	
	// modify user details
	public void adminModifyUsers(User user, int userId) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();

		User u = ses.find(User.class, userId);
		
		if(u!=null) {
			u.setName(user.getName());
	        u.setEmail(user.getEmail());
	        u.setPassword(user.getPassword());
			ses.saveOrUpdate(u);
			tax.commit();
			System.out.println("modified user details of " + user.getName());
		}
		else {
			System.out.println("User does not exists!");
		}
		ses.close();
	}
	
	
	// logout admin
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
	
	// add question
	public void adminAddQuestion(Question ques) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		ses.save(ques);
		tax.commit();
		System.out.println("Question Added!");
		ses.close();
	}
	
	// view all questions
	public void adminViewQuestions() {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<Question> query = ses.createQuery("from Question");
		List<Question> qlist = query.list();
		
		for(Question q : qlist) {
			System.out.println(q.toString());
		}
		ses.close();
	}
	
	// remove question
	public void adminRemoveQuestion(int qId) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();
		
		Query<Question> query = ses.createQuery("from Question where qId=:qId");
		query.setParameter("qId", qId);
		
		Question q = query.uniqueResult();
		
		ses.delete(q);
		tax.commit();
		System.out.println("Question has been removed!");
		ses.close();
	}
	
	//modify question
	public void adminModifyQuestion(Question ques, int qId) {
		ses = util.getSessionFactory().openSession();
		Transaction tax = ses.beginTransaction();

		Question q = ses.find(Question.class, qId);
		
		if(q!=null) {
			q.setqText(ques.getqText());
			q.setOptionA(ques.getOptionA());
			q.setOptionB(ques.getOptionB());
			q.setOptionC(ques.getOptionC());
			q.setOptionD(ques.getOptionD());
			q.setCorrectAnswer(ques.getCorrectAnswer());
			ses.saveOrUpdate(q);
			tax.commit();
			System.out.println("modified question!");
		}
		else {
			System.out.println("Question does not exists!");
		}
		ses.close();
	}
}

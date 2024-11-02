package com.hexaware.OnlineExamSystem.com.hexaware.OnlineExamSystemHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hexaware.OnlineExamSystem.Model.User;
import com.hexaware.OnlineExamSystem.Service.AdminServices;
import com.hexaware.OnlineExamSystem.Service.UserServices;

/**
 * Hello world!
 *
 */
public class App {
	SessionFactory fac;
	Session ses;

	App() {

		fac = new Configuration().configure("hiber.config.xml").addAnnotatedClass(User.class).buildSessionFactory();

	}

	public void registerUser(String role) {
		UserServices userv = new UserServices();
		Scanner sc = new Scanner(System.in);

		ses = fac.openSession();
		Transaction tax = ses.beginTransaction();

		while (true) {
			System.out.println("******** MAIN MENU ********");
			System.out.println("Enter your choice\n1. Sign Up\n2. Login\n3. Back");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Sign Up ");
				userv.signUp(role);
				break;
			case 2:
				System.out.println("Login");
				User usr = userv.signIn();
				if (role.equals("User")) {
					userServices(usr);
				} else if (role.equals("Admin")) {
					adminServices(usr);
				}
				break;
			case 3:
				System.out.println("back to Choose role page");
				return;
			}
		}
	}

	public void userServices(User user) {
		UserServices userv = new UserServices();
		Scanner sc = new Scanner(System.in);

		ses = fac.openSession();
		Transaction tax = ses.beginTransaction();

		while (true) {
			System.out.println("******** USER MENU ********");
			System.out.println("Enter your choice\n1. Modify Email\n2. Modify Password\n3. Log Out");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Modify Email");
				userv.modifyEmail(user);
				break;
			case 2:
				System.out.println("Modify password");
				userv.modifyPassword(user);
				break;
			case 3:
				System.out.println("Log Out");
				userv.logOut(user);
				return;
			}
		}
	}

	public void adminServices(User user) {
		Scanner sc = new Scanner(System.in);
		AdminServices aserv = new AdminServices();
		ses = fac.openSession();
		Transaction tax = ses.beginTransaction();

		while (true) {
			System.out.println("******** ADMIN MENU ********");
			System.out.println(
					"Enter your choice\n1. View All users\n2. Add User\n3. Remove User\n4. Modify User\n5. View All Questions\n6. Add Questions \n7. Modify Questions \n8. Remove Questions \n9. Log Out");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("View all users");
				aserv.viewAllUsers();
				break;
			case 2:
				System.out.println("Add Users");
				aserv.addUser();
				break;
			case 3:
				System.out.println("Remove Users");
				aserv.removeUser();
				break;
			case 4:
				System.out.println("Modify User");
				aserv.modifyUser();
				break;
			case 5:
				System.out.println("View All Questions");
				aserv.viewAllQuestions();
				break;
			case 6:
				System.out.println("Add Questions");
				aserv.addQuestion();
				break;
			case 7:
				System.out.println("Modify Questions");
				aserv.modifyQuestion();
				break;
			case 8:
				System.out.println("Remove questions");
				aserv.removeQuestion();
				break;
			case 9:
				System.out.println("Log Out");
				aserv.logoutAdmin(user);
				return;
			}
		}
	}

	public static void main(String[] args) {
		App app = new App();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("******* ONLINE EXAM SYSTEM *******");
			System.out.println("Enter your Role \n1. Admin \n2. User\n3. Exit");
			int role = sc.nextInt();
			sc.nextLine();

			switch (role) {
			case 1: {
				app.registerUser("Admin");
				break;
			}
			case 2: {
				app.registerUser("User");
				break;
			}
			case 3: {
				System.out.println("Exiting......");
				return;
			}
			}
		}

	}
}

package com.hexaware.OnlineExamSystem.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hexaware.OnlineExamSystem.Model.User;

public class ConnectionUtil {
	
	private SessionFactory fac = new Configuration().configure("hiber.config.xml").addAnnotatedClass(User.class).buildSessionFactory();
	
	 public SessionFactory getSessionFactory() {
		 return fac;
	 }
	
	
}

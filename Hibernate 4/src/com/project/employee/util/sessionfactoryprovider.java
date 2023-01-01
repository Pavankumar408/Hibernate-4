package com.project.employee.util;

import java.util.Objects;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class sessionfactoryprovider {
	private static SessionFactory sessionfactory=null;
	static {
		sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
	public static  SessionFactory getsessionfactory() {
		if (Objects.nonNull(sessionfactory)){
			return sessionfactory;
			
		}
		else {
			System.out.println("session factory is not created");
			return sessionfactory;
		}
		
		}
	public static void closesessionfactory() {
		if(sessionfactory!=null) {
			sessionfactory.close();
			System.out.println("session factory is closed");
		}
		else {
			System.out.println("session factory is not closed");
		}
		
	}

}

package com.project.demo.employeedao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.demo.employee;
import com.project.employee.util.sessionfactoryprovider;

public class employeedaoimpl implements employeedao {

	@Override
	public void saveemployeedetails() {
		System.out.println("employeedaoimpl.saveemployeedetails()");
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			sessionfactory=sessionfactoryprovider.getsessionfactory();
			 session=sessionfactory.openSession();
			session.beginTransaction();
			employee emp=new employee( "srini", 35, "M", 40000);
			employee emp2=new employee( "karthi", 28, "M", 35000);
			employee emp3=new employee( "varsha", 23, "F", 25000);
			employee emp4=new employee("swathi", 22,"F", 35000);
			session.save(emp4);
			System.out.println("data saved sucessfully");
			session.getTransaction().commit();
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	 finally {
		 if(session!=null) {
			 System.out.println("session is closed");
			 session.close();
		 }
		 else {
			 System.out.println("session is not closed");
		 }
		 sessionfactoryprovider.closesessionfactory();
	 }
		
		
	}

	@Override
	public void getemployeedetails() {
		System.out.println("employeedaoimpl.getemployeedetails()");
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			sessionfactory=sessionfactoryprovider.getsessionfactory();
			 session=sessionfactory.openSession();
			 employee Employee=session.get(employee.class, 4);
			 System.out.println("data is done"+Employee);
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			sessionfactoryprovider.closesessionfactory();
		 }
	}

	@Override
	public void updateemployeedetails() {
		System.out.println("employeedaoimpl.updateemployeedetails()");
		SessionFactory sessionfactory=null;
		Session session=null;
		Transaction trans=null;
		try {
			sessionfactory=sessionfactoryprovider.getsessionfactory();
			 session=sessionfactory.openSession();
			 employee Employee=session.get(employee.class, 3);
			 System.out.println(" before data is updated"+Employee);
			 Employee.setName("varsha");
			 Employee.setAge(23);
			 Employee.setGender("F");
			 Employee.setSalary(25000);
			 trans=session.beginTransaction();
			 session.update(Employee);
			 trans.commit();
			 System.out.println("data is updated sucessfully");
			 	
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			//trans.rollback();
		}
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			sessionfactoryprovider.closesessionfactory();
		 }
		
		
		
		
		
	}

	@Override
	public void deleteemployeedata() {
		System.out.println("employeedaoimpl.deleteemployeedata()");
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			sessionfactory=sessionfactoryprovider.getsessionfactory();
			 session=sessionfactory.openSession();
			 session.beginTransaction();
			 employee Employee=session.get(employee.class, 3);
			 session.delete(Employee);
			 session.getTransaction().commit();
			 System.out.println("data is deleted sucessfully");
			 
			 
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			sessionfactoryprovider.closesessionfactory();
		 }
		
	}

}

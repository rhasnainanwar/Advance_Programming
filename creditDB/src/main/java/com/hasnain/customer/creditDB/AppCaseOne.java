package com.hasnain.customer.creditDB;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppCaseOne 
{
	@SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
    	
    	SessionFactory factory;
    	
    	try {
    		File f = new File("hibernate.cfg.xml"); 
            factory = new Configuration().configure(f).buildSessionFactory();
         } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    	
    	Session sess = factory.openSession();
    	    	
    	System.out.println("CREATION");
    	Transaction t = sess.beginTransaction();
    	
    	CustomerDetail detail1 = new CustomerDetail();
    	detail1.setAddress("RUMI 3, NUST, H12, Islamabad."); detail1.setCreditScore(65); detail1.setRewardPoints(4);
    	
    	Customer cust1 = new Customer();
    	cust1.setId(182599); cust1.setName("Kamran Janjua"); cust1.setDetail(detail1);
    	
    	CustomerDetail detail2 = new CustomerDetail();
    	detail2.setAddress("SEECS, NUST, H12, Islamabad."); detail2.setCreditScore(45); detail2.setRewardPoints(8);
    	
    	Customer cust2 = new Customer();
    	cust2.setId(192135); cust2.setName("Raja Hasnain Anwar"); cust2.setDetail(detail2);
    	
    	sess.persist(cust1);
    	sess.persist(cust2);
    	
    	try {
    		t.commit();
    		System.out.println(cust1.toString());
    		System.out.println(cust2.toString());
    		System.out.println("Data committed successfully!");
    	} catch (Exception e) {
    		System.out.println("Some error occured while saving the data. Rolling back...");
    		t.rollback();
    	}
    	System.out.println();
    	
    	System.out.println("UPDATE");
    	Transaction t1 = sess.beginTransaction();
    	
    	cust1.setName("Muhammad Kamran Janjua");
    	
    	Query q = sess.createQuery("UPDATE CustomerComb SET customerName=:name WHERE customerId=:id");
    	q.setParameter("name", cust1.getName());
    	q.setParameter("id", cust1.getId());
    	
    	int status = q.executeUpdate();
    	System.out.println("Status: " + status);
    	
    	try {
    		t1.commit();
    		System.out.println(cust1.toString());
    		System.out.println("Changes committed successfully!");
    	} catch (Exception e) {
    		System.out.println("Some error occured while saving the data. Rolling back...");
    		t1.rollback();
    	}
    	System.out.println();
    	
    	System.out.println("DELETION");
    	Transaction t2 = sess.beginTransaction();
    	
    	Query q1 = sess.createQuery("DELETE from CustomerComb WHERE customerId=:id");
    	q1.setParameter("id", cust2.getId());
    	
    	try {
    		t2.commit();
    		System.out.println(cust2.toString());
    		System.out.println("Deleted committed successfully!");
    	} catch (Exception e) {
    		System.out.println("Some error occured while deleting. Rolling back...");
    		t2.rollback();
    	}
    	System.out.println();
    	
    	System.out.println("READ");
    	Query q2 = sess.createQuery("FROM CustomerComb");
    	List<CustomerComb> list = q2.list();
    	System.out.println(list);
    	
    	sess.close();
    }
}

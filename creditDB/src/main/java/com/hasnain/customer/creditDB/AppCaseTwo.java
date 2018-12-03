package com.hasnain.customer.creditDB;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppCaseTwo
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
    	
    	CustomerComb cust = new CustomerComb();
    	cust.setId(192135); cust.setName("Raja Hasnain Anwar"); cust.setAddress("SEECS, NUST, H12, Islamabad.");
    	cust.setCreditScore(4565); cust.setRewardPoints(564);
    	
    	CustomerComb cust1 = new CustomerComb();
    	cust1.setId(182599); cust1.setName("Kamran Janjua"); cust1.setAddress("RUMI 3, NUST, H12, Islamabad.");
    	cust1.setCreditScore(512); cust1.setRewardPoints(9);
    	
    	sess.persist(cust);
    	sess.persist(cust1);
    	
    	try {
    		t.commit();
    		System.out.println(cust.toString());
    		System.out.println(cust1.toString());
    		System.out.println("Data committed successfully!");
    	} catch (Exception e) {
    		System.out.println("Some error occured while saving the data. Rolling back...");
    		t.rollback();
    	}
    	System.out.println();
    	
    	System.out.println("UPDATE");
    	Transaction t1 = sess.beginTransaction();
    	
    	cust1.setName("Muhammad Kamran Janjua");
    	
    	Query q = sess.createQuery("UPDATE Customer SET customerName=:name WHERE customerId=:id");
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
    	
    	Query q1 = sess.createQuery("DELETE from Customer WHERE customerId=:id");
    	q1.setParameter("id", cust.getId());
    	
    	try {
    		t2.commit();
    		System.out.println(cust.toString());
    		System.out.println("Deleted committed successfully!");
    	} catch (Exception e) {
    		System.out.println("Some error occured while deleting. Rolling back...");
    		t2.rollback();
    	}
    	System.out.println();
    	
    	System.out.println("READ");
    	Query q2 = sess.createQuery("FROM Customer");
    	List<CustomerComb> list = q2.list();
    	System.out.println(list);
    	
    	sess.close();
    }
}

//Perform Save operation to implement timestamp and versioning

package com.abc.timestamp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.timestamp.Product;

public class SaveOpreation {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("/com/abc/timestamp/cfgs/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Product pro1=new Product();
		pro1.setId("201");
		pro1.setName("Note");
		pro1.setPrice(85.00);
	
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(pro1);
			tx.commit();
			System.out.println("Saved successfully");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("Failed");
			System.out.println(e);
		}
		
		session.close();
		factory.close();
	}

}

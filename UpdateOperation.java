//Perform Update operation to update versioning

package com.abc.timestamp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.timestamp.Product;

public class UpdateOperation {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("/com/abc/timestamp/cfgs/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Object obj=session.load(Product.class, new String("201"));
		Product pro1=(Product) obj;
		pro1.setName("Book");
		pro1.setPrice(500.00);
	
		
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

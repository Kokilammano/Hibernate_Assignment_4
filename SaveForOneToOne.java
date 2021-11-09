//Perform save operation to implement one to one relation

package com.abc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.domain.OneToOne.Address;
import com.abc.domain.OneToOne.Employ_Det;

public class Save {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("/com/abc/cfgs/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Address addr=new Address();
		addr.setCity("Chennai");
		addr.setState("Tamilnadu");
		addr.setCountry("India");
		
		Employ_Det emp=new Employ_Det();
		emp.setId(1);
		emp.setName("Nivi");
		emp.setMobile(998765467);
		emp.setCity(addr);
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(addr);
			session.save(emp);
			tx.commit();
			System.out.println("Saved successfully");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("Failed");
		}
		
		session.close();
		factory.close();
	}

}

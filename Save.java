//Perform save operation to implement one to many relation

package com.abc.test;

import java.util.HashSet;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.OneToMany.Address;
import com.abc.OneToMany.Employ;

public class Save {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("/com/abc/cfgs/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Address addr1=new Address();
		addr1.setCity("Coimbatore");
		addr1.setState("TamilNadu");
		addr1.setCountry("India");
		
		Address addr2=new Address();
		addr2.setCity("Chennai");
		addr2.setState("TamilNadu");
		addr2.setCountry("India");
		
		Address addr3=new Address();
		addr3.setCity("Cochi");
		addr3.setState("Kerala");
		addr3.setCountry("India");
		
		Set<Address> addr=new HashSet<Address>();
		addr.add(addr1);
		addr.add(addr2);
		addr.add(addr3);
		
		Employ emp=new Employ();
		emp.setName("Abi");
		emp.setMobile(998766544);
		emp.setAddr(addr);
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
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

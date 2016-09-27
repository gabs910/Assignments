package ssa;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class createMajor {

	public static void main(String[] args) {
		newMajor();
		updateMajor();
		deleteMajor();
		display();
	}

	
	
// create a new major in the major table	
public static void newMajor(){
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	try{
		Major maj1 = new Major("Pre-Law",1300);
		Major maj2 = new Major("Communications",800);
	
		
		//begin transaction
		session.beginTransaction();
		
		session.save(maj1);
		session.save(maj2);
		
		System.out.println("Created new majors");
		session.getTransaction().commit();
		
	} catch(Exception ex){ ex.getStackTrace(); 
		
	} finally {
		factory.close();
	}
}

public static void updateMajor() {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	try{		
		//begin transaction
		session.beginTransaction();
//		session.createQuery("update Major set description = 'Beauty School' where id =7").executeUpdate();
		session.createQuery("update Major set description = 'Sports Management' where id =1").executeUpdate();

		session.getTransaction().commit();
		System.out.println("update Major table");
		
	} catch(Exception ex){ ex.getStackTrace(); 
		
	} finally {
		factory.close();
	}
}
public static void deleteMajor() {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	try{	
		int majorId=9;
		//begin transaction
		session.beginTransaction();
		Major major = session.get(Major.class,majorId);
		
		session.delete(major);
		
		System.out.println("delete major nursing");
		session.getTransaction().commit();
		
	} catch(Exception ex){ ex.getStackTrace(); 
		
	} finally {
		factory.close();
	}
}
private static void display() {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Major.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();
	try{	
		session.beginTransaction();

		List<Major> majors1= session.createQuery("from Major").list();
		for(Major maj: majors1)
			System.out.println(maj);

		session.getTransaction().commit();
		
	} catch(Exception ex){ ex.getStackTrace(); 
		
	} finally {
		factory.close();
	}
}



}







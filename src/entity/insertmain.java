package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class insertmain {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student1.class).buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try{
			//create a student object
			System.out.println("creating a new student object,...");
			student1 s1 =new student1();
			s1.setEmail("sonu@gmail.com");
			s1.setFirstname("sumit12");
			s1.setLastname("raghav");
			
			
			//start a transaction 
			session.beginTransaction();
			//save the student object
			System.out.println("saving the student....");
			session.save(s1);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}finally{
			factory.close();
		}

	}



}

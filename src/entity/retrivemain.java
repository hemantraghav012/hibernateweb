package entity;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class retrivemain {

	public static void main(String[] args) {
	
		//create session factory
				SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(student1.class).buildSessionFactory();
				//create session
				Session session=factory.getCurrentSession();
				try{
	
					//start a transaction 
					session.beginTransaction();
					List <student1>thestudent=session.createQuery("from student1").list();
					//display the student data
					for(student1 stu:thestudent){
						System.out.println(stu.getFirstname());
						System.out.println(stu.getEmail());
						System.out.println(stu.getLastname());
					}
					//commit transaction					
					session.getTransaction().commit();
					System.out.println("done");
					
				}finally{
					factory.close();
				}
	}

}

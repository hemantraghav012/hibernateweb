package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@RequestScoped
@ManagedBean
@Entity
@Table(name="student1")
public class student1 {
	@Id
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String  lastname;
	@Column(name="email")
	private String  email;
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String save(){
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(student1.class).buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try{
			//create a student object
			System.out.println("creating a new student object,...");
			
		this.setEmail(email);
		this.setFirstname(firstname);
		this.setLastname(lastname);
			
			
			//start a transaction 
			session.beginTransaction();
			//save the student object
			System.out.println("saving the student....");
			session.save(this);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}finally{
			factory.close();
		}

		
		return "success.xhtml";
	}
	
	
	

}

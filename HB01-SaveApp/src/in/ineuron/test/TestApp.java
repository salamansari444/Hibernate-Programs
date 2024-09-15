package in.ineuron.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;



public class TestApp {

	public static void main(String[] args) throws Exception {
		// 1. Inform JVM to activate HIBERNATE
		Configuration configuration= new Configuration();
		configuration.configure();
		
		// Creating a SessionFactory object to hold many other objects required for HIBERNATE
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		
		// Using SessionFactory object, get only one Session object to perform our persistence operation
		// 
		Session session=sessionFactory.openSession();  // connection object,ORM-dialects,L1-Cache,TXTManagement
		
		Transaction transaction=session.beginTransaction();  //begin the transaction
		
		// 2. create PERSISTENCE object
		Student student=new Student();
		
		student.setSid(7);
		student.setSname("Dhoni");
		student.setSaddress("CSK");
		student.setSage(41);
		
		
		
		// 3. perform PERSISTENCE operation using Entity/Model/POJO object
		session.save(student);
		
		

		// 4. commit the operation based on the result
		transaction.commit();
		
		System.out.println("...object save to database......");
	}

}

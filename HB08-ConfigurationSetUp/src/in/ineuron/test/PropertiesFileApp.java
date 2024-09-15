package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class PropertiesFileApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		int id=7;
		try {
			Configuration configuration = new Configuration();
			sessionFactory=configuration.buildSessionFactory();
			session=sessionFactory.openSession();
			
			Student student=session.get(Student.class, id);
			if(student!=null) {
				System.out.println("Before update table : "+student);
			}else {
				System.out.println("Record not available for the given id : "+id);
			}
			
			}
			catch (HibernateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				session.close();
				sessionFactory.close();
			}
		}

	

}

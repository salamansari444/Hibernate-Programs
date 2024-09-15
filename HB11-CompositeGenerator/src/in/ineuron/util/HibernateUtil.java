package in.ineuron.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.model.Student;

public class HibernateUtil implements Serializable{
	
	private static SessionFactory sessionFactory=null;
	
	private static Session session=null;	
	
	private HibernateUtil() {}
	
	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(ProgrammerProjInfo.class).buildSessionFactory();
	} 
	
	public static Session getSession() {
		if(session==null)
			session=sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
}

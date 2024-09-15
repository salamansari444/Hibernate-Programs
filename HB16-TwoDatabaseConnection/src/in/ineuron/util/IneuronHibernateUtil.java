package in.ineuron.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Product;


public class IneuronHibernateUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = null;

	private static Session session = null;

	private IneuronHibernateUtil() {
	}

	static {
		sessionFactory = new Configuration().configure("src/in/ineuron/cfg/ineuronHibernate.cfg.xml")
				.addAnnotatedClass(Product.class).buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}

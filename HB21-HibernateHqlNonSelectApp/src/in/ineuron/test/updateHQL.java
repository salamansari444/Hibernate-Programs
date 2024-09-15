package in.ineuron.test;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class updateHQL {
	public static void main(String[] args) {
		
	
	Session session=null;
	Integer count=null;
	Boolean flag=false;
	Transaction transaction=null;
	try {
		session = HibernateUtil.getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("UPDATE in.ineuron.model.Product SET qty=qty+:newQty WHERE pname like:initialLetter");
		int id=1;
		query.setParameter("newQty", 5);
		query.setParameter("initialLetter", "f%");
		
		count = query.executeUpdate();
		flag=true;
		

	} catch (HibernateException e) {
		e.printStackTrace();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(flag) {
			transaction.commit();
			System.out.println("now of rows  affected is :"+count);
		}
		else {
			transaction.rollback();
			System.out.println("failed to update");
		}
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}

	}
}

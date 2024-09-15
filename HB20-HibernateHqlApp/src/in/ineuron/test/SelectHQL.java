package in.ineuron.test;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectHQL {
	public static void main(String[] args) {
		
	
	Session session=null;


	try {
		session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM in.ineuron.model.Product where pid=:id");
		int id=1;
		query.setParameter("id", id);
		
		Product product = (Product) query.uniqueResult();
		if(product!=null) {
			System.out.println("uniqueResult :"+product);
		}
		else {
			System.out.println("record not avaialble for the given id: "+id);
		}
		System.out.println();
		System.out.println();
		//with Optional
		Optional<Product> optional =  query.uniqueResultOptional();
		if(optional.isPresent()) {
			System.out.println("uniqueResultOptional "+product);
		}
		else {
			System.out.println("record not avaialble for the given id: "+id);
		}
		
		

	} catch (HibernateException e) {
		e.printStackTrace();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}

	}
}

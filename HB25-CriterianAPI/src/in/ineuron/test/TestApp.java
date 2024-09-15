package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session=null;
		
		try {
			session=HibernateUtil.getSession();

			//prepare the Query
			Query<Object[]> query=session.createQuery("SELECT pname,price,qty FROM in.ineuron.model.Product WHERE pname IN(:prod1,:prod2)");
			
			query.setParameter("prod1", "fossil");
			query.setParameter("prod2", "tide");
			
			List<Object[]> product = query.list();
			System.out.println("PRICE\tQTY");
			product.forEach(row->{
				for(Object object:row) {
					System.out.println(object+"\t");
				}
				System.out.println();
			});
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}

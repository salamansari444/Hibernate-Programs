package in.ineuron.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectFilterAppHQL {

	public static void main(String[] args) {
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			
	
			Query<BankAccount> query=session.createQuery("FROM in.ineuron.model.BankAccount where balance>=:amt");
			

			query.setParameter("amt", 2000.0f);
			
			List<BankAccount> account = query.list();
			
			for(BankAccount ba: account) {
				System.out.println(ba);
			}
			

		} catch (HibernateException he) {
			he.printStackTrace();
			
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

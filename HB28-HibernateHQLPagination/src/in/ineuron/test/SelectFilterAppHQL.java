package in.ineuron.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectFilterAppHQL {

	public static void main(String[] args) {
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			
	
			Query<InsurancePolicy> query=session.createQuery("FROM in.ineuron.model.InsurancePolicy ");
			

			query.setFirstResult(0);
			query.setMaxResults(7);
			
			List<InsurancePolicy> account = query.list();
			
			for(InsurancePolicy ba: account) {
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

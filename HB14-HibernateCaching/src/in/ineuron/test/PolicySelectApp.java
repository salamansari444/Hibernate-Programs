package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class PolicySelectApp {
	public static void main(String[] args) throws IOException {

		Session session = null;
		int id = 1;
		boolean flag = false;
		InsurancePolicy policy=null;
		Transaction transaction=null;
		try {
			session = HibernateUtil.getSession();
			policy =session.get(InsurancePolicy.class, 1L);
			System.out.println("1:: "+policy);
			policy =session.get(InsurancePolicy.class, 1L);
			System.out.println("2:: "+policy);
			session.evict(policy);
			policy =session.get(InsurancePolicy.class, 1L);
			System.out.println("3:: "+policy);
			session.clear();
			Thread.sleep(20000);
			policy =session.get(InsurancePolicy.class, 1L);
			System.out.println("4 after sleep:: "+policy);
			
			
			
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}

	}

}

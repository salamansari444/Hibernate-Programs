package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.util.HibernateUtil;

public class NamedTagged {

	public static void main(String[] args) {
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
	

			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");
			nativeQuery.setParameter(1, "quarterly");
			List<Object[]> policies = nativeQuery.getResultList();
			System.out.println("PID\t PNAME \t POLICTYPE");
			policies.forEach(row->{
				for(Object obj : row) {
					System.out.println(obj + "\t");
				}
			});

			

			

		} catch (HibernateException he) {
			he.printStackTrace();
			
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

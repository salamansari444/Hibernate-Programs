package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsertHql {

	public static void main(String[] args) {
		Session session=null;
		session = HibernateUtil.getSession();
		try {
		NativeQuery<InsurancePolicy[]> nativeQuery = session
				.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?");

		//Setting the parameter
		nativeQuery.setParameter(1, 15);
		nativeQuery.setParameter(2, 30);

		//Executing to get the result
		List<InsurancePolicy[]> policies = nativeQuery.getResultList();
		
		//Mapping the result with entity class
		nativeQuery.addEntity(InsurancePolicy.class);
		
		//Processing the result
		System.out.println("PID\tPNAME\tPTYPE\tTENURE\tCOMPANY");
		policies.forEach(row -> {
			for (Object obj : row) {
				System.out.print(obj + "\t");
			}
			System.out.println();
		});
	} catch (HibernateException he) {
		he.printStackTrace();
	} finally {
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}
	}

	}



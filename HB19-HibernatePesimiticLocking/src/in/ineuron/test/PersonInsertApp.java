package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class PersonInsertApp {

	public static void main(String[] args) throws IOException {

		
		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				InsurancePolicy policy = new InsurancePolicy();
				policy.setPolicyName("JeevanNigam");
				policy.setPolicyType("yearly");
				policy.setTenure(8);
				policy.setCompany("IDFC");
				id = (Integer) session.save(policy);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

		
	}

}

package in.ineuron.test;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class PolicyInsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;
		InsurancePolicy policy=null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {

				policy = new InsurancePolicy();
				policy.setPolicyName("Jeevan Bhima");
				policy.setPolicyType("Yearly");
				policy.setCompany("HDFC");
				policy.setTenure(20);
				id = (Long) session.save(policy);
				flag = true;

			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("data save to database with id: " + id);
			} else {
				transaction.rollback();
				System.out.println("data failed to save");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}

	}

}

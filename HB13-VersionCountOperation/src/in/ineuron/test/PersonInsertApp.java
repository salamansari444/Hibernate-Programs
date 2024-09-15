package in.ineuron.test;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class PersonInsertApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {

				MobileCustomer customer = new MobileCustomer();
				customer.setCname("BOFA");
				customer.setMobileNo(8201298873L);
				customer.setCallerTune("siddo hi gal ye arf wallah");
				id = (Integer) session.save(customer);
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

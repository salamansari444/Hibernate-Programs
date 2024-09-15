package in.ineuron.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
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

				PersonInfo info = new PersonInfo();
				info.setPname("Salam");
				info.setDob(LocalDate.of(1999, 02, 12));
				info.setDom(LocalDateTime.of(1995, 5, 25, 7, 45));
				info.setDoj(LocalTime.of(9, 15));
				id = (Integer) session.save(info);
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

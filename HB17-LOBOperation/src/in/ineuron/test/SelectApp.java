package in.ineuron.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 3;
		boolean flag = false;
		JobSeeker seeker = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				seeker = session.get(JobSeeker.class, id);
				transaction = session.beginTransaction();
				if (seeker != null) {
					System.out.println("Id is       :: " + seeker.getJsId());
					System.out.println("Name is     :: " + seeker.getJsName());
					System.out.println("Address is  :: " + seeker.getJsAddr());

					try (FileOutputStream fos = new FileOutputStream("./store/salam.JPG");
							FileWriter writer = new FileWriter("./store/resume.txt")) {
						fos.write(seeker.getPhoto());
						writer.write(seeker.getResume());
						System.out.println("Photo and resume got downloaded to :: ./store/****");
					}

				} else {
					System.out.println("Record not available for the given id :: " + id);
				}

			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("data save to database");
			} else {
				transaction.rollback();
				System.out.println("data failed to save");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

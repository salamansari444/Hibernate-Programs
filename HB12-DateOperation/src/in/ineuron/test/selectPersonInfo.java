package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;

import in.ineuron.util.HibernateUtil;

public class selectPersonInfo {
	public static void main(String[] args) throws IOException {

		Session session = null;
		int id = 1;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			PersonInfo personInfo = session.get(PersonInfo.class, id);
			if (personInfo != null) {
				System.out.println(personInfo);
			} else {
				System.out.println("record not availble for the given id :" + id);
			}

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

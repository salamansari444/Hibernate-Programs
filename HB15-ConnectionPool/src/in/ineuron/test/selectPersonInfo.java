package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class selectPersonInfo {
	public static void main(String[] args) throws IOException {

		Session session = null;
		int id = 1;
		boolean flag = false;
		MobileCustomer customer=null;
		Transaction transaction=null;
		try {
			session = HibernateUtil.getSession();
			customer =session.get(MobileCustomer.class, id);
			System.out.println("After loading...."+customer);
			
			transaction=session.beginTransaction();
			if(transaction!=null) {
				customer.setCallerTune("La la la la");
				session.update(customer);
				flag=true;
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Data updated for the given id :: "+id);
				System.out.println("After Updation : "+customer);
			}
			else {
				transaction.rollback();
				System.out.println("Data not updated to database");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}

	}

}

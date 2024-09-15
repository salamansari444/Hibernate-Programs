package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class DeleteUsingHQL {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction =null;
		Boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("data get deleted");
			}
			else {
				transaction.rollback();
				System.out.println(" failed......");
			}
		}
	}

}

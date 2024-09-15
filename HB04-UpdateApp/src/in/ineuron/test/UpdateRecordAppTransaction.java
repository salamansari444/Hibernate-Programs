package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateRecordAppTransaction {

	public static void main(String[] args) throws IOException {
		
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			Student student=session.get(Student.class, 88);

			if (session != null) {
				transaction=session.beginTransaction();
				if(transaction!=null) {
					student.setSname("Mahi");
					flag=true;
				}
				else {
					System.out.println("record not available for update..");
				}
			}
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag)
				transaction.commit();
			else {
				transaction.rollback();
				System.out.println("record not available for update..");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}

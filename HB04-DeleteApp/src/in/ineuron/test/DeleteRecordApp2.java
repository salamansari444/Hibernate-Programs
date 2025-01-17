package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp2 {

	public static void main(String[] args) throws IOException {
		
		Session session = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			int id=1;
			Student student=session.get(Student.class, id);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				if(student!=null) {
					
					session.delete(student);
					flag = true;
				}
				else {
					System.out.println("Record not avaiable for delete.....");
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
			if (flag) {
				System.in.read();
				transaction.commit();
				System.out.println("Object delete from the database....");
			} else {
				transaction.rollback();
				System.out.println("Object not deleted from the database...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}

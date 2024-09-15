package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class ClientApp2 {
	public static void main(String[] args) throws IOException {

		Session session = null;
		int id = 1;
		boolean flag = false;
		InsurancePolicy policy=null;
		Transaction transaction=null;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			policy = session.get(InsurancePolicy.class, id,LockMode.UPGRADE_NOWAIT);
			System.out.println(policy);
			
		
			policy.setPolicyName("FRY Loan");
			flag=true;
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Data updated for the given id :: "+id);
				System.out.println("After Updation : "+policy);
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

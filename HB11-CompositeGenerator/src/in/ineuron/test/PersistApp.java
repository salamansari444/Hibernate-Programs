package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class PersistApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		ProgrammerProjId pk=null;
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			if(transaction!=null) {
				
				ProgrammerProjId id=new ProgrammerProjId();
				id.setPid(100);
				id.setProjid(501);
				ProgrammerProjInfo info=new ProgrammerProjInfo();
				info.setId(id);
				info.setPname("Salam");
				info.setDeptno(10);
				info.setProjName("Library");
				
				pk=(ProgrammerProjId)session.save(info);
				flag=true;
				
			
			}
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("data save to database with id: "+pk);
			}
			else {
				transaction.rollback();
				System.out.println("data failed to save");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}

}

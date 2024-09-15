package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class selectApp {
public static void main(String[] args) throws IOException {
		
		Session session=null;
		
		boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			ProgrammerProjId id=new ProgrammerProjId();
			id.setPid(100);
			id.setProjid(501);
			ProgrammerProjInfo object=session.get(ProgrammerProjInfo.class, id);
			if(object!=null) {
				System.out.println(object);
			}
			else {
				System.out.println("record not availble for the given id :"+object);
			}
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}

	}


}

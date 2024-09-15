package in.ineuron.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import in.ineuron.model.Employee;


import in.ineuron.util.HibernateUtil;

public class SaveRecordApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			if(transaction!=null) {
				Employee emp=new Employee();
				
				emp.setEid(216);
				emp.setEname("salam");
				emp.setEaddress("Mumbai");
				
				emp.setFriendlist(List.of("Rukku","Balam", "faisal"));
				
				emp.setPhone(Set.of(8291255014l,82998787l,456789456l));
				
				emp.setBankAccount((Map.of("SBI",112233L,"HDFC",223344L,"ICICI",112244L)));
				
				
				
				session.save(emp);
				flag=true;
			}
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("data save to database");
			}
			else {
				transaction.rollback();
				System.out.println("Data  failed to save in database .....");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

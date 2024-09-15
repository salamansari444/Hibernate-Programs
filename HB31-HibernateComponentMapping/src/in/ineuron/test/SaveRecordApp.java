package in.ineuron.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Address;
import in.ineuron.model.StudentInfo;
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
				Address address=new Address();
				address.setCityName("Mumbai");
				address.setStateName("Maharashtra");
				address.setCountryName("India");
				
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setSname("Salam");
				studentInfo.setAge(23);
				studentInfo.setAddress(address);
				
				 session.save(studentInfo);
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

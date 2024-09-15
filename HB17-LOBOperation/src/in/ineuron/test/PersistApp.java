package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class PersistApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		Transaction transaction=null;
		byte[] photo=null;
		char[] resume=null;
		boolean flag=false;
		Integer id = null;

		try(FileInputStream fis=new FileInputStream("D:\\image\\salam.JPG")) {
			photo =new byte[fis.available()];
			fis.read(photo);
		}
		try {
			File f=new File("D:\\image\\history.txt");
		try(FileReader fr=new FileReader(f)){
			resume =new char[(int)f.length()];
			fr.read(resume);
			}
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				JobSeeker jobSeeker = new JobSeeker();
				jobSeeker.setJsName("salam");
				jobSeeker.setJsAddr("Mumbai");
				jobSeeker.setPhoto(photo);
				jobSeeker.setResume(resume);
				
				id = (Integer) session.save(jobSeeker);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}

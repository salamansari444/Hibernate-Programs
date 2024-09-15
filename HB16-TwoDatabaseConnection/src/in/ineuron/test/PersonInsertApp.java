package in.ineuron.test;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dao.ITransferDao;
import in.ineuron.dao.TransferDaoImpl;
import in.ineuron.model.Product;
import in.ineuron.util.IneuronHibernateUtil;
import in.ineuron.util.OctbatchHibernateUtil;

public class PersonInsertApp {

	public static void main(String[] args) throws IOException {
		ITransferDao dao=new TransferDaoImpl();
		System.out.println(dao.transferProductById(10));	
		
		IneuronHibernateUtil.closeSessionFactory();
		OctbatchHibernateUtil.closeSessionFactory();	
		
		}
}

package in.ineuron.test;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;

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
				CardPayment card=new CardPayment();
				card.setPid(1234);
				card.setAmount(5000.0f);
				 card.setCardType("Debit");
				 card.setCardNo(345678l);
				 card.setPaymentGateway("Rupay");
				 
				 
				 
				 
				 ChequePayment cheque = new ChequePayment();
				 cheque.setPid(4556);
				 cheque.setAmount(5000.0f);
				 cheque.setChequeNo(3567l);
				 cheque.setChequeType("Self");
				 cheque.setExpiryDate(LocalDate.of(2023, 03, 12));
				 
				 
				 session.save(card);
				 session.save(cheque);
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

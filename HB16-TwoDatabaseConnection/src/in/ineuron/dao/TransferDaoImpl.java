package in.ineuron.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Product;
import in.ineuron.util.IneuronHibernateUtil;
import in.ineuron.util.OctbatchHibernateUtil;

public class TransferDaoImpl implements ITransferDao {

	@Override
	public String transferProductById(Integer id) {

		Session ineuronSession  = IneuronHibernateUtil.getSession();
		Session octbatchSession = OctbatchHibernateUtil.getSession();
		Transaction octbatchTransaction = octbatchSession.beginTransaction();
		boolean flag = false;
		Integer idValue = null;

		Product product = ineuronSession.get(Product.class, id);
		try {
			if (product == null) {
				return "Record not Avaialble";
			} else {
				idValue = (Integer) octbatchSession.save(product);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				octbatchTransaction.commit();
				return "data copied with id" + idValue;
			} else {
				octbatchTransaction.rollback();
				return "data not copied" + idValue;
			}
		}

	}

}

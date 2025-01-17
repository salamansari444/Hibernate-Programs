package in.ineuron.dao;

import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	private static final String HQL_TRANFER_POLICIES = "INSERT INTO in.ineuron.model.PremiumInsurancePolicy(policyId,policyName,policyType,company,tenure) SELECT i.policyId,i.policyName,i.policyType,i.company,i.tenure FROM in.ineuron.model.InsurancePolicy as i where i.tenure>=:min";

	
	@Override
	public String transaferPolicies(int minTenure) {
		Session session=null;
		Transaction transaction=null;
		int rowTransfered=0;
		@SuppressWarnings("rawtypes")
		Query query=null;
		boolean flag=false;
		String msg="";
		
		try {
			session=HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			session.createQuery(HQL_TRANFER_POLICIES);
			query.setParameter("min", minTenure);
			
			rowTransfered= query.executeUpdate();
			flag = true;

			
			
		}
		catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				msg = "No of rows transferred is :: " + rowTransfered;
			} else {
				transaction.rollback();
				msg = "records not copied to table";
			}
		
	}
		return msg;

}
}

package in.ineuron.test;


import in.ineuron.dao.InsurancePolicyDao;
import in.ineuron.dao.InsurancePolicyDaoImpl;

public class InsertHql {

	public static void main(String[] args) {
		InsurancePolicyDao insuranceDao=new InsurancePolicyDaoImpl();
		String result = insuranceDao.transaferPolicies(15);
		System.out.println(result);
	}

	}



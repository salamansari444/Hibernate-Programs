package in.ineuron.dao;

import java.util.List;
import in.ineuron.model.*;


public interface InsurancePolicyDao {
	List<InsurancePolicy> getPageData(int pageSize, int startPos);
	public Long getTotalRecordsCount();
}

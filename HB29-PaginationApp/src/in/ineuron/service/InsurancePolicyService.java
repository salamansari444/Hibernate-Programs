package in.ineuron.service;

import java.util.List;
import in.ineuron.dto.*;

public interface InsurancePolicyService {
	public long fetchPagesCount(int pageSize);

	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);

}

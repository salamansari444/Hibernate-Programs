package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Version;

@Entity
@NamedNativeQuery(name="GET_ALL_POLICIES_TYPE", query="SELECT POLICYID,POLICYNAME,POLICYTYPE FROM INSURANCEPOLICY WHERE POLICYTYPE=?")
public class InsurancePolicy  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;

	

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", company=" + company + ", policyName=" + policyName
				+ ", policyType=" + policyType + ", tenure=" + tenure + "]";
	}

	

}

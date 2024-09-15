package in.ineuron.dto;

public class InsurancePolicyDTO {
	private Integer policyId;
	private String company;
	private String policyName;
	private String policyType;
	private Integer tenure;
	
	static {
		System.out.println(".class file is loading..");
	}
	
	public InsurancePolicyDTO() {
		System.out.println("object use by Hibernate DTO");
	}
	

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
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

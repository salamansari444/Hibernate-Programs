package in.ineuron.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "EMPLOYEE_COLLECTION")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer eid;
	private String ename;
	private String eaddress;

	@ElementCollection
	@Column(name = "friends_name")
	@CollectionTable(name = "Emp_Friends", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid"))
	@OrderColumn(name = "friend_no")
	@ListIndexBase(value = 1)
	private List<String> friendlist;

	@ElementCollection
	@Column(name = "Mobile_no")
	@CollectionTable(name = "emp_phone", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid"))
	private Set<Long> phone;

	@ElementCollection
	@Column(name = "account_number")
	@CollectionTable(name = "emp_accounts", joinColumns = @JoinColumn(name = "empi_id", referencedColumnName = "eid"))
	@MapKeyColumn(name = "bank_name", length = 10)
	private Map<String, Long> bankAccount;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public List<String> getFriendlist() {
		return friendlist;
	}

	public void setFriendlist(List<String> friendlist) {
		this.friendlist = friendlist;
	}

	public Set<Long> getPhone() {
		return phone;
	}

	public void setPhone(Set<Long> phone) {
		this.phone = phone;
	}

	public Map<String, Long> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Map<String, Long> bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friendlist=" + friendlist
				+ ", phone=" + phone + ", bankAccount=" + bankAccount + "]";
	}

}

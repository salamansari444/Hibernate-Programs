package in.ineuron.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STDTAB")
public class Student {
	
	@Id
	@Column(name="stdId")
	private Integer sid;
	
	@Column(name="stdname" , length=20)
	private String sname;
	
	@Column(name="stdAddr", length=20)
	private String saddress;
	
	@Column(name="stdAge")
	private Integer sage;
	
	public Student() {
		System.out.println("Student.Student() : Hibernate uses zero argunment constructor internally");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
	
	
	
}

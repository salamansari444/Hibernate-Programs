package in.ineuron.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class Student {
	
	@Id
//	@GenericGenerator(name="gen1", strategy="increment")
//	@GeneratedValue(generator="gen1")
//	@GenericGenerator(name="gen1", strategy="sequence")
//	@GeneratedValue(generator="gen1")
//	@GenericGenerator(name="gen1", strategy="identity")
//	@GeneratedValue(generator="gen1")
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	
	private String sname;

	private String saddress;

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

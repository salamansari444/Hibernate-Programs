package in.ineuron.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjInfo {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgrammerProjId id;

	private String pname;
	private int deptno;
	private String projName;

	public ProgrammerProjId getId() {
		return id;
	}

	public void setId(ProgrammerProjId id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjInfo [id=" + id + ", pname=" + pname + ", deptno=" + deptno + ", projName=" + projName
				+ "]";
	}

}

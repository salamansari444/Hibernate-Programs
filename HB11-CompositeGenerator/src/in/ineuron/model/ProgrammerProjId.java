package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class ProgrammerProjId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer projid;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getProjid() {
		return projid;
	}

	public void setProjid(Integer projid) {
		this.projid = projid;
	}

	@Override
	public String toString() {
		return "ProgrammerProjId [pid=" + pid + ", projid=" + projid + "]";
	}

}

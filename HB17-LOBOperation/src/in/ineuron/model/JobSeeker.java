package in.ineuron.model;


import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity

public class JobSeeker implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	@GenericGenerator(name="gen1", strategy="increment")
//	@GeneratedValue(generator="gen1")
//	@GenericGenerator(name="gen1", strategy="sequence")
//	@GeneratedValue(generator="gen1")
//	@GenericGenerator(name="gen1", strategy="identity")
//	@GeneratedValue(generator="gen1")
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jsId;
	private String jsName;
	private String jsAddr;
	
	@Lob
	private byte [] photo;
	
	@Lob
	private char[] resume;

	public Integer getJsId() {
		return jsId;
	}

	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}

	public String getJsName() {
		return jsName;
	}

	public void setJsName(String jsName) {
		this.jsName = jsName;
	}

	public String getJsAddr() {
		return jsAddr;
	}

	public void setJsAddr(String jsAddr) {
		this.jsAddr = jsAddr;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	
	@Override
	public String toString() {
		return "JobSeeker [jsId=" + jsId + ", jsName=" + jsName + ", jsAddr=" + jsAddr + ", photo="
				+ Arrays.toString(photo) + ", resume=" + Arrays.toString(resume) + "]";
	}
	
	
	
}

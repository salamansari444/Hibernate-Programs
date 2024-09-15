package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	public String save(String sname, Integer sage, String saddress);

	public Student findById(Integer sid);

	public String updatetStudent(Student student);

	public String delete(Integer sid);

}

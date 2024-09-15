package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
	public String save(String sname, Integer sage, String saddress);

	public Student findById(Integer sid);

	public String updatetStudent(Student student);

	public String delete(Integer sid);


}

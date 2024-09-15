package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao=null;
	@Override
	public String save(String sname, Integer sage, String saddress) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.save(sname, sage, saddress);
	}

	@Override
	public Student findById(Integer sid) {		
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.findById(sid);
	}

	@Override
	public String updatetStudent(Student student) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updatetStudent(student);
	}

	@Override
	public String delete(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.delete(sid);
	}

}

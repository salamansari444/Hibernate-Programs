package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();
	Transaction transaction = null;

	@Override
	public String save(String sname, Integer sage, String saddress) {
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		String status = "";
		try {
			if (transaction != null) {
				Student student = new Student();

				student.setSname(sname);
				student.setSage(sage);
				student.setSaddress(saddress);

				session.persist(student);
				flag = true;

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {

		Student student = session.get(Student.class, sid);
		if (student != null) {
			return student;
		}
		return null;
	}

	@Override
	public String updatetStudent(Student student) {
		String msg = "";
		transaction = session.beginTransaction();
		boolean flag=false;
		try {
			if(transaction!=null) {
				session.saveOrUpdate(student);
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				msg="sucess";
			}
			else {
				transaction.rollback();
				msg="failed";
			}
		}
		return msg;

	}

	@Override
	public String delete(Integer sid) {

		Student student = findById(sid);
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		String status = "";
		try {
			if (student != null) {
				session.delete(student);
				flag = true;
			} else {
				System.out.println("record not found for the given id : " + sid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}

}

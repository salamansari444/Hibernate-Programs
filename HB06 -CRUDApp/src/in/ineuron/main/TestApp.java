package in.ineuron.main;

import java.util.Scanner;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
		//insertOperation();
		//selectOpeartion();
		updateOperation();
	}

	private static void insertOperation() {

		IStudentService studentService = StudentServiceFactory.getStudentService();

		String msg = studentService.save("sadd", 23, "edr");
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}

	}

	private static void selectOpeartion() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID :: ");
		int sid=sc.nextInt();
		IStudentService studentService=StudentServiceFactory.getStudentService();
//		Student student=new Student();
//		student.setSid(1);
		
		Student student=studentService.findById(sid);
		if(student!=null) {
			System.out.println(student);
		}
		else {
			System.out.println("Record not found for the given id::"+student.getSid());
		}
		
	}
	
	
	
	
	private static void updateOperation() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student ID :: ");
		int sid=sc.nextInt();
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Student student =studentService.findById(sid);
		if(student!=null) {
			Student newstudent=new Student();
			newstudent.setSid(student.getSid());
			newstudent.setSname("benaam");
			newstudent.setSage(12);
			newstudent.setSaddress("WDR");
			
			String msg = studentService.updatetStudent(newstudent);
			if(msg.equalsIgnoreCase("success")) {
				System.out.println("Record Updated Successfully");
			}
			else {
				System.out.println("Record Updated Failed ......");
			}
		}
		System.out.println("record not avaialble for the given id :: "+sid);
	}
}

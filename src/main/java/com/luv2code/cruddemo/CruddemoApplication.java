package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);

//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");
		int numRows = studentDAO.deleteAll();
		System.out.println(numRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
		System.out.println("Deleting student: " + studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
//		int studentID = 1;
		Student myStudent = studentDAO.findById(1);
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findByLastName("Muaz");

		for (Student tempStudent: theStudent){
			System.out.println(theStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display the students
		for(Student student : theStudents) {
			System.out.println(student);
		}


	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Zara","Muaz","test@luv2code.com");
		studentDAO.save(tempStudent);
		int studentId = tempStudent.getId();
		Student myStudent = studentDAO.findById(studentId);
		System.out.println(myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student tempStudent  = new Student("Deen", "Muaz", "deen@luv2code.com");
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("saved student, Generated id: " + tempStudent.getId());
	}

}

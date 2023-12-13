package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Zara","Muaz","test@luv2code.com");
		studentDAO.save(tempStudent);
		int studentId = tempStudent.getId();
		studentDAO.findById(studentId);
		System.out.println(tempStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object");
		Student tempStudent  = new Student("Deen", "Muaz", "deen@luv2code.com");
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("saved student, Generated id: " + tempStudent.getId());
	}

}

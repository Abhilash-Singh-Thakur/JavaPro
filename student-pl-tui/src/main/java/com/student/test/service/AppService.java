package com.student.test.service;

import java.util.List;
import java.util.Scanner;

import com.student.test.dao.StudentDao;
import com.student.test.model.Student;

public class AppService {

	public void add(Scanner scan) {
		StudentDao dao = new StudentDao();
		Student student = new Student();
		System.out.print("Enter id: ");
		student.setId(scan.nextInt());
		System.out.print("Enter name: ");
		student.setName(scan.next());
		System.out.print("Enter address: ");
		student.setAddress(scan.next());
		System.out.print("Enter percentage: ");
		student.setPercentage(scan.nextDouble());
		dao.create(student);
		System.out.println("Student added successfully.");
	}

	public void update(Scanner scan) {
		StudentDao dao = new StudentDao();
		Student student = new Student();
		System.out.print("Enter name: ");
		student.setName(scan.next());
		System.out.print("Enter address: ");
		student.setAddress(scan.next());
		System.out.print("Enter percentage: ");
		student.setPercentage(scan.nextDouble());
		System.out.print("Enter id: ");
		student.setId(scan.nextInt());
		dao.update(student);
		System.out.println("Record updated successfully.");
	}

	public void searchAll() {
		StudentDao dao = new StudentDao();
		List<Student> list = dao.findall();
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();
	}

	public void searchById(Scanner scan) {
		StudentDao dao = new StudentDao();
		System.out.print("Enter id: ");
		int a = scan.nextInt();
		Student student = dao.findOneByID(a);
		System.out.println(student + "");
	}

	public void delete(Scanner scan) {
		StudentDao dao = new StudentDao();
		System.out.print("Enter id: ");
		int b = scan.nextInt();
		dao.deleteByid(b);
		System.out.println("Record deleted successfully");
	}
}

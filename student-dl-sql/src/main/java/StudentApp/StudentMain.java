package StudentApp;

import java.util.Scanner;
import MyConnection.StudentDao;
import Student.Student;

public class StudentMain {
	
	 public StudentMain() {
     }

	public static void main(String[] args) {
		System.out.println("Welcome to the Student App");
		System.out.println("choose from the below options");
		System.out.println("1 Add Student ");
		System.out.println("2 Update Student ");	
		System.out.println("3 List of Students ");	
		System.out.println("4 Search Student ");	
		System.out.println("5 Delete Student ");
		
		try {
			Student student = new Student(0, null, null, 0);
			Scanner s = new Scanner(System.in);
			System.out.println("Enter option number");
			int i =s.nextInt();
			while (i==1||i==2||i==3||i==4||i==5) 
			{
				if (i==1) {
					try {
					System.out.println("Enter the id");
					student.setId(s.nextInt());
					System.out.println("Enter the name");
					student.setName(s.next());
					System.out.println("Enter the address");
					student.setAddress(s.next());
					System.out.println("Enter the percentage");
					student.setPercentage(s.nextDouble());
					StudentDao.create(student);
					System.out.println("New Student's record saved");
					}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Wrong input...");
				}
				    break;
				}
				else if (i==2) {
					try {
						System.out.println("Enter the name");
						student.setName(s.next());
						System.out.println("Enter the address");
						student.setAddress(s.next());
						System.out.println("Enter the percentage");
						student.setPercentage(s.nextDouble());
						System.out.println("Enter the id");
						student.setId(s.nextInt());
						StudentDao.update(student);
						System.out.println("Record updated");
						} 
					catch (Exception e) {
						e.printStackTrace();
					    System.out.println("Wrong input...");
						}
					    break;
			          }
				else if (i==3) {
					try {
						System.out.println("This is the record");
						System.out.println(StudentDao.findall());
						
						} 
					catch (Exception e) {
						e.printStackTrace();
					    System.out.println("Wrong input...");
						}
					    break;
			          }
				else if (i==4) {
					try {
						System.out.println("Enter the id");
						int a =s.nextInt();
						System.out.println(StudentDao.findOneByID(a));
						System.out.println("");
						} 
					catch (Exception e) {
						e.printStackTrace();
					    System.out.println("Wrong input...");
						}
					    break;
			          }
				else if (i==5) {
					try {
						System.out.println("Enter the id");
						int b = s.nextInt();
						StudentDao.deleteByid(b);
						System.out.println("Record deleted");
						} 
					catch (Exception e) {
						e.printStackTrace();
					    System.out.println("Wrong input...");
						}
					    break;
			          }
		       } 
		}
		catch (Exception e) {
			System.out.println("wrong input....");
		}
		
	}

}

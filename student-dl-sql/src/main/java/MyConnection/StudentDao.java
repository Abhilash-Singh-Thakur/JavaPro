package MyConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Student.Student;

public class StudentDao {
	private static final String insert = "insert into student values(?,?,?,?);";
	private static final String update = "update Student set name=?,address=?,percentage=? where id = ?";
	private static final String showAll = "select * from student;";
	private static final String byid = "select id,name,address,percentage from student where id = ?;";
	private static final String del = "delete from Student where id=?;";
	

	public static Student create(Student student) throws SQLException{
	     try {
	    	 Connection connection = ConnectionProvider.getConnection();
	    	 PreparedStatement preparedStatement = connection.prepareStatement(insert);
//	    	 Scanner s = new Scanner(System.in);
//	    	 System.out.println("Enter the student id");
//	    	 int id = s.nextInt();
//	    	 System.out.println("Enter the student name");
//	    	 String name = s.next();
//	    	 System.out.println("Enter the student address");
//	    	 String address = s.next();
//	    	 System.out.println("Enter the student percentage");
//	    	 double percentage = s.nextDouble();
	    	 
	    	 preparedStatement.setInt(1, student.getId());
	    	 preparedStatement.setString(2, student.getName());
	    	 preparedStatement.setString(3, student.getAddress());
	    	 preparedStatement.setDouble(4, student.getPercentage());
	    	 
	    	 preparedStatement.executeUpdate();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;		
	}
	
	
	public static Student update(Student student) throws SQLException {
	     try {
	    	 Connection connection = ConnectionProvider.getConnection();
	    	 PreparedStatement preparedStatement = connection.prepareStatement(update);
	    	 preparedStatement.setString(2, student.getName());
	    	 preparedStatement.setString(3, student.getAddress());
	    	 preparedStatement.setDouble(4, student.getPercentage());
	    	 preparedStatement.setInt(1, student.getId());
	    	 preparedStatement.executeUpdate();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;

      }
	
	public static List<Student> findall(){
		List<Student> student = new ArrayList<Student>();
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(showAll);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int id  = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				double percentage = rs.getDouble ("percentage");
			    student.add(new Student(id, name, address, percentage));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
	public static Student findOneByID (int id) {

	         Student student = null;
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(byid);
			preparedStatement.setInt(1,id);
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()) {
				int id1  = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				double percentage = rs.getDouble ("percentage");
				student = new Student(id,name,address,percentage);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
		}
	
	
	public static void deleteByid (int id) throws SQLException{
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(del);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
    }	
	
	public static void main(String[]args) throws SQLException {
		StudentDao.deleteByid(12);
		
		
}
	
}


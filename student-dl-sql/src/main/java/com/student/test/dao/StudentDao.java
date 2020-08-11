package com.student.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.test.config.ConnectionConfig;
import com.student.test.exception.AppException;
import com.student.test.model.Student;

public class StudentDao {
	private static final String insert = "insert into student values(?,?,?,?);";
	private static final String update = "update Student set name=?,address=?,percentage=? where id = ?";
	private static final String showAll = "select * from student;";
	private static final String byid = "select id,name,address,percentage from student where id = ?;";
	private static final String del = "delete from Student where id=?;";

	public Student create(Student student) throws AppException {
		try (Connection connection = ConnectionConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);

			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getAddress());
			preparedStatement.setDouble(4, student.getPercentage());
			preparedStatement.executeUpdate();
			return student;
		} catch (SQLException e) {
			throw new AppException(e.getMessage());
		}
	}

	public Student update(Student student) throws AppException {
		Student studentDB = this.findOneByID(student.getId());
		if (studentDB == null) {
			throw new AppException("Record not found for this id: " + student.getId());
		}
		try (Connection connection = ConnectionConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getAddress());
			preparedStatement.setDouble(4, student.getPercentage());
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
			return student;
		} catch (SQLException e) {
			throw new AppException(e.getMessage());
		}
	}

	public List<Student> findall() throws AppException {
		try (Connection connection = ConnectionConfig.getConnection()) {
			List<Student> student = new ArrayList<Student>();
			PreparedStatement preparedStatement = connection.prepareStatement(showAll);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				double percentage = rs.getDouble("percentage");
				student.add(new Student(id, name, address, percentage));
			}
			return student;
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
	}

	public Student findOneByID(int id) throws AppException {

		Student student = null;
		try (Connection connection = ConnectionConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(byid);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				double percentage = rs.getDouble("percentage");
				student = new Student(id1, name, address, percentage);
			}
			return student;
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
	}

	public void deleteByid(int id) throws AppException {
		try (Connection connection = ConnectionConfig.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(del);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
	}

}

package ssa;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.mysql.jdbc.Connection;

public class Students extends HashMap<Integer, Student> {

	private static final long serialVersionUID = 1L;
	static SqlConnDB db = null;

	private static void makeConnection() throws FileNotFoundException, IOException, SQLException {
		try {

			Properties prop = new Properties();
			prop.load(new FileInputStream("src/ssa/info.properties"));
			String dburl = prop.getProperty("dburl");
			String user = prop.getProperty("user");
			String pass = prop.getProperty("pass");
			db = new SqlConnDB(dburl, user, pass);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteId(int id) {
		String sql = String.format("DELETE from student where id = %d", id);
		try {
			db.runUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void insert(Student student) {
		String sql = String.format("INSERT student (first_name, last_name, gpa, sat) values ('%s', '%s', %f, %d)",
				student.firstName, student.lastName, student.gpa, student.sat);
		try {
			db.runUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void update(Student student) {
		String sql = String.format(
				"UPDATE student set first_name = '%s', last_name = '%s', gpa = %f, sat = %d where id = %d",
				student.firstName, student.lastName, student.gpa, student.sat, student.id);
		try {
			db.runUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Student returnId(int id) {
		List<Student> students = choose("Select * from student where id = " + id);
		if (students.isEmpty())
			return null;
		return students.get(0);
	}

	public List<Student> showAll() {
		return choose("SELECT * from student");
	}

	public static List<Student> choose(String sql) {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			ResultSet rs = db.executeSqlQuery(sql);
			while (rs.next()) {
				Student student = loadStudent(rs);
				students.add(student);
			}
			return students;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static Student loadStudent(ResultSet rs) {
		Student student = new Student();
		try {
			student.id = rs.getInt("id");
			student.firstName = rs.getString("first_name");
			student.lastName = rs.getString("last_name");
			student.gpa = rs.getDouble("gpa");
			student.sat = rs.getInt("sat");
			return student;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Student newStudent() {
		Student student = new Student();
		return student;
	}

	public Students() throws FileNotFoundException, IOException, SQLException {
		super();
		makeConnection();
	}

}

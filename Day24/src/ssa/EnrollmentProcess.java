package ssa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EnrollmentProcess {

	public static Connection myConn = null;
	public static PreparedStatement myStmt = null;
	public static ResultSet myRs = null;
	public static int studentSat;
	public static int minimumSat;
	public static void main(String[] args) throws SQLException {
		//fetchData();

		System.out.println("");
		//enrollStudent(200, "Adam", "Zapel", 1200, 3.0, 3);
		//enrollStudent(230, "Graham", "Krakir", 500, 2.5, 7);
		//enrollStudent(240, "Ella", "Vader", 800, 3.0, 2);
		//enrollStudent(250, "Stanley", "Kupp", 1350, 3.3, 5);
		//enrollStudent(260, "Lou", "Zar", 9500, 3.0, 6);
		fetchData();
		System.out.println("");
		updateMajor(2,110);
		fetchData();

	}

	public static void enrollStudent(int id, String firstName, String lastName, int sat, double gpa, int major_id)
			throws SQLException {

		try {

			makeConnection();
			myStmt = (PreparedStatement) myConn.prepareStatement(
					"insert into student(id,first_name,last_name,gpa,sat,major_id) values(?,?,?,?,?,?)");

			myStmt.setInt(1, id);
			myStmt.setString(2, firstName);
			myStmt.setString(3, lastName);
			myStmt.setDouble(4, gpa);
			myStmt.setInt(5, sat);
			myStmt.setInt(6, major_id);

			myStmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
	}

	public static void display() throws SQLException {
		while (myRs.next()) {

			String fName = myRs.getString("first_name");
			String lName = myRs.getString("last_name");
			double gpa = myRs.getDouble("gpa");
			int sat = myRs.getInt("sat");
			int maj = myRs.getInt("major_id");

			System.out.printf("%s %s %.2f %d %d\n", fName, lName, gpa, sat, maj);
		}
	}

	public static void fetchData() throws SQLException {
		try {
			makeConnection();
			myStmt = (PreparedStatement) myConn.prepareStatement("select * from student where gpa > ? and sat > ?");

			// Set parameter Values
			myStmt.setDouble(1, 1.0);
			myStmt.setInt(2, 100);

			// Execute the query
			myRs = myStmt.executeQuery();

			// process result
			display();

			// Set parameter Values
			myStmt.setDouble(1, 3.0);
			myStmt.setInt(2, 900);
			myRs = myStmt.executeQuery();
			display();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}

	private static void makeConnection() throws FileNotFoundException, IOException, SQLException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("info.properties"));
		String dburl = prop.getProperty("dburl");
		String user = prop.getProperty("user");
		String pass = prop.getProperty("password");
		myConn = (Connection) DriverManager.getConnection(dburl, user, pass);

	}

	public static void close() throws SQLException {
			if(myConn!=null)
				myConn.close();
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			
		}


	private static void updateMajor(int majorId, int studentId) throws SQLException {
        try {
            makeConnection();
            myStmt = (PreparedStatement) myConn.prepareStatement("select req_sat from major where id = ?");
            myStmt.setInt(1,majorId);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                minimumSat = myRs.getInt("req_sat");
            }
            
            myStmt = (PreparedStatement) myConn.prepareStatement("select sat from student where id = ?");
            myStmt.setInt(1,studentId);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                studentSat = myRs.getInt("sat");
            }
            if (studentSat >= minimumSat) {
                myStmt = (PreparedStatement) myConn.prepareStatement("update student set major_id = ? where id = ?");
                myStmt.setInt(1,majorId);
                myStmt.setInt(2,studentId);
                myStmt.executeUpdate();
            }
            else {
                System.out.println("Error: Student SAT does not meet minimum SAT for this major");
            }
						
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally { 
				close();
			}
	}
	
	private static void enrollClass(int student_id, int class_id) throws SQLException{
		
		try{
			
			makeConnection();
			myStmt=(PreparedStatement) myConn.prepareStatement("insert student_class_relationship(class_id,student_id=");
			
			myStmt.setInt(1,student_id);
			myStmt.setInt(2,class_id);
			
			myStmt.executeUpdate();
					
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally { 
			close();
		}
}
}



	

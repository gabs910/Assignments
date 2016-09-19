package ssa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Mainline {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
	    Students students = new Students();
	  
//	    // retrieve a single student with id = 150
	    Student aStudent = students.returnId(150);
//	    // display the student
	    System.out.println(aStudent); // displays the student data in a formatted way
//	    // retrieve all the students into a collection
	    ArrayList<Student> allStudents = (ArrayList<Student>) Students.choose("select * from student where gpa between 2 and 3.5 order by sat");
//	    // iterate through the collection and display each student data in a formatted way
	    for(Student student : allStudents) {
	        System.out.println(student);
	    }
}
}

